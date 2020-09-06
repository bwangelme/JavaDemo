package com.bwangel.headfirstjava;

import java.util.ArrayList;


/**
 * Board 表示一张棋盘，原点在左上角
 */
public class Board {
    private Integer width;
    private Integer height;

    Board(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 检查棋盘上取的点 pos 是否在边界上
     * @param pos 取的点
     * @param excludeSize 边界的宽度
     * @param borderDirection true 水平边界，false 垂直边界
     * @return 是否在边界上
     */
    public boolean isPosInBorder(int pos, int excludeSize, boolean borderDirection) {
        int x = pos % this.width;  // 点的横坐标
        int y = pos / this.width;  // 点的纵坐标

        if(borderDirection) {
            // 点的位置在棋盘最下边 excludeSize 行上
            if (y >= this.height - excludeSize) {
                return true;
            }
        } else {
            // 点的位置在棋盘最右边的 excludeSize 列上
            if (x >= this.width - excludeSize) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在 width * height 的棋盘上任意取N个连续的点
     */
    public ArrayList<String> getRandomCoordinate(Integer num) {
        ArrayList<String> locations = new ArrayList<>();
        // 连续 N 个点的排列方向， false 是横向，true 是纵向
        boolean isVertical = false;
        boolean canRandomDirection = true;
        int excludeSize = num - 1;

        if (this.width < num && this.height < num) {
            System.out.printf("棋盘大小(%d * %d)小于取点个数: %d，无法取点\n", this.width, this.height, num);
            return locations;
        }

        // 棋盘宽度小于 num，只能纵向取点
        if (this.width < num) {
            // 只能横向取点
            canRandomDirection = false;
            isVertical = false;
        } else if (this.height < num) {
            // 只能纵向取点
            canRandomDirection = false;
            isVertical = true;
        }


        while (true) {
            // 生成一个 [0, width*height - 1] 范围内的随机数，表示起始位置
            int pos = (int) (Math.random() * (width * height));

            if (canRandomDirection) {
                isVertical = (int) (Math.random() * 100) >= 50;
            }

            if (this.isPosInBorder(pos, excludeSize, !isVertical)) {
                continue;
            }
            if (isVertical) {
                locations.add(this.getCoordinateFromPos(pos));
                locations.add(this.getCoordinateFromPos(pos + this.width));
                locations.add(this.getCoordinateFromPos(pos + 2 * this.width));
            } else {
                locations.add(this.getCoordinateFromPos(pos));
                locations.add(this.getCoordinateFromPos(pos + 1));
                locations.add(this.getCoordinateFromPos(pos + 2));
            }

            return locations;
        }
    }

    /**
     * 通过一个数值获取棋盘上的坐标
     *
     * @param pos    数值
     * @return 坐标 横坐标为 A-Z，纵坐标为 0 - (height - 1)
     */
    public String getCoordinateFromPos(int pos) {
        int y = pos / width;
        int x = pos % width;
        return this.getLetterFromNum(y) + x;
    }

    /**
     * 通过数字获取到对应的字母 0 ~ A, 1 ~ B ...
     *
     * @param num 数字
     * @return num 对应的字母
     */
    public String getLetterFromNum(int num) {
        char letter = (char) (num % 26 + (int) ('A'));
        return String.valueOf(letter);
    }
}
