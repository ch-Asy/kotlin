package com.cn.kotlin;

import java.util.List;

/**
 * Created by anliyuan on 2017/11/10.
 */

public class BannerData {

    private String msg;
    private String error;
    private List<BannerItem> row;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<BannerItem> getRow() {
        return row;
    }

    public void setRow(List<BannerItem> row) {
        this.row = row;
    }

    public static class BannerItem {
        /**
         * img : 71568270.jpg
         * downurl : 测试九
         * id : 13
         * isdelete : 1
         * title : 测试九
         */

        private String img;
        private String downurl;
        private int id;
        private int isdelete;
        private String title;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(int isdelete) {
            this.isdelete = isdelete;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
