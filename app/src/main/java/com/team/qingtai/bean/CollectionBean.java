package com.team.qingtai.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ymh on 2016/5/19.
 */
public class CollectionBean {

    /**
     * version : v1.0
     * data : [{"id":462,"owner_id":348,"owner_nickname":"test","owner_gender":0,"owner_avatar":"a31f5c67465a4685242bc222a0e4fa94.jpg","owner_type":0,"title":"test","contents":"test","visit_num":20,"article_type":0,"num_favorite":1,"num_comments":1,"create_time":"2016-05-04 21:17:47","pic":[""]},{"id":443,"owner_id":195,"owner_nickname":"Yu2016","owner_gender":0,"owner_avatar":"869bd99ee937c882db33867852d14ffc.jpg","owner_type":0,"title":"test","contents":"。。。","visit_num":40,"article_type":0,"num_favorite":1,"num_comments":2,"create_time":"2016-03-13 22:50:47","pic":["25f12f9b01b2137f8fcd0f3cd83412e1.jpg"]}]
     * msg : ok
     * code : 0
     */

    private String version;
    private String msg;
    private int code;
    /**
     * id : 462
     * owner_id : 348
     * owner_nickname : test
     * owner_gender : 0
     * owner_avatar : a31f5c67465a4685242bc222a0e4fa94.jpg
     * owner_type : 0
     * title : test
     * contents : test
     * visit_num : 20
     * article_type : 0
     * num_favorite : 1
     * num_comments : 1
     * create_time : 2016-05-04 21:17:47
     * pic : [""]
     */

    private List<DataEntity> data;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable {
        private int id;
        private int owner_id;
        private String owner_nickname;
        private int owner_gender;
        private String owner_avatar;
        private int owner_type;
        private String title;
        private String contents;
        private int visit_num;
        private int article_type;
        private int num_favorite;
        private int num_comments;
        private String create_time;
        private List<String> pic;

        public void setId(int id) {
            this.id = id;
        }

        public void setOwner_id(int owner_id) {
            this.owner_id = owner_id;
        }

        public void setOwner_nickname(String owner_nickname) {
            this.owner_nickname = owner_nickname;
        }

        public void setOwner_gender(int owner_gender) {
            this.owner_gender = owner_gender;
        }

        public void setOwner_avatar(String owner_avatar) {
            this.owner_avatar = owner_avatar;
        }

        public void setOwner_type(int owner_type) {
            this.owner_type = owner_type;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public void setVisit_num(int visit_num) {
            this.visit_num = visit_num;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }

        public void setNum_favorite(int num_favorite) {
            this.num_favorite = num_favorite;
        }

        public void setNum_comments(int num_comments) {
            this.num_comments = num_comments;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setPic(List<String> pic) {
            this.pic = pic;
        }

        public int getId() {
            return id;
        }

        public int getOwner_id() {
            return owner_id;
        }

        public String getOwner_nickname() {
            return owner_nickname;
        }

        public int getOwner_gender() {
            return owner_gender;
        }

        public String getOwner_avatar() {
            return owner_avatar;
        }

        public int getOwner_type() {
            return owner_type;
        }

        public String getTitle() {
            return title;
        }

        public String getContents() {
            return contents;
        }

        public int getVisit_num() {
            return visit_num;
        }

        public int getArticle_type() {
            return article_type;
        }

        public int getNum_favorite() {
            return num_favorite;
        }

        public int getNum_comments() {
            return num_comments;
        }

        public String getCreate_time() {
            return create_time;
        }

        public List<String> getPic() {
            return pic;
        }
    }
}
