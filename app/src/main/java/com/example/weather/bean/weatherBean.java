package com.example.weather.bean;

import java.util.List;

public class weatherBean {

    /**
     * message : success感谢又拍云(upyun.com)提供CDN赞助
     * status : 200
     * date : 20240408
     * time : 2024-04-08 18:41:28
     * cityInfo : {"city":"北京市","citykey":"101010100","parent":"北京","updateTime":"15:01"}
     * data : {"shidu":"27%","pm25":27,"pm10":171,"quality":"轻度","wendu":"18","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼","forecast":[{"date":"08","high":"高温 21℃","low":"低温 12℃","ymd":"2024-04-08","week":"星期一","sunrise":"05:45","sunset":"18:45","aqi":125,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","high":"高温 17℃","low":"低温 8℃","ymd":"2024-04-09","week":"星期二","sunrise":"05:44","sunset":"18:46","aqi":122,"fx":"南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","high":"高温 17℃","low":"低温 7℃","ymd":"2024-04-10","week":"星期三","sunrise":"05:42","sunset":"18:47","aqi":126,"fx":"东南风","fl":"2级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"11","high":"高温 25℃","low":"低温 7℃","ymd":"2024-04-11","week":"星期四","sunrise":"05:41","sunset":"18:48","aqi":117,"fx":"南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 28℃","low":"低温 12℃","ymd":"2024-04-12","week":"星期五","sunrise":"05:39","sunset":"18:49","aqi":119,"fx":"南风","fl":"1级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"13","high":"高温 28℃","low":"低温 13℃","ymd":"2024-04-13","week":"星期六","sunrise":"05:38","sunset":"18:50","aqi":111,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"14","high":"高温 21℃","low":"低温 15℃","ymd":"2024-04-14","week":"星期日","sunrise":"05:36","sunset":"18:51","aqi":114,"fx":"东风","fl":"2级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"15","high":"高温 22℃","low":"低温 11℃","ymd":"2024-04-15","week":"星期一","sunrise":"05:35","sunset":"18:52","aqi":115,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","high":"高温 25℃","low":"低温 9℃","ymd":"2024-04-16","week":"星期二","sunrise":"05:33","sunset":"18:53","aqi":102,"fx":"北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"17","high":"高温 28℃","low":"低温 10℃","ymd":"2024-04-17","week":"星期三","sunrise":"05:32","sunset":"18:54","aqi":114,"fx":"东南风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","high":"高温 23℃","low":"低温 16℃","ymd":"2024-04-18","week":"星期四","sunrise":"05:30","sunset":"18:55","aqi":108,"fx":"西南风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"19","high":"高温 17℃","low":"低温 12℃","ymd":"2024-04-19","week":"星期五","sunrise":"05:29","sunset":"18:56","aqi":127,"fx":"南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"20","high":"高温 24℃","low":"低温 11℃","ymd":"2024-04-20","week":"星期六","sunrise":"05:28","sunset":"18:57","aqi":126,"fx":"西南风","fl":"1级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"21","high":"高温 26℃","low":"低温 15℃","ymd":"2024-04-21","week":"星期日","sunrise":"05:26","sunset":"18:58","aqi":100,"fx":"西南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"22","high":"高温 22℃","low":"低温 13℃","ymd":"2024-04-22","week":"星期一","sunrise":"05:25","sunset":"18:59","aqi":113,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}],"yesterday":{"date":"07","high":"高温 26℃","low":"低温 11℃","ymd":"2024-04-07","week":"星期日","sunrise":"05:47","sunset":"18:44","aqi":40,"fx":"西风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}}
     */

    private String message;
    private int status;
    private String date;
    private String time;
    private CityInfoBean cityInfo;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 北京市
         * citykey : 101010100
         * parent : 北京
         * updateTime : 15:01
         */

        private String city;
        private String citykey;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 27%
         * pm25 : 27
         * pm10 : 171
         * quality : 轻度
         * wendu : 18
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
         * forecast : [{"date":"08","high":"高温 21℃","low":"低温 12℃","ymd":"2024-04-08","week":"星期一","sunrise":"05:45","sunset":"18:45","aqi":125,"fx":"东南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","high":"高温 17℃","low":"低温 8℃","ymd":"2024-04-09","week":"星期二","sunrise":"05:44","sunset":"18:46","aqi":122,"fx":"南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","high":"高温 17℃","low":"低温 7℃","ymd":"2024-04-10","week":"星期三","sunrise":"05:42","sunset":"18:47","aqi":126,"fx":"东南风","fl":"2级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"11","high":"高温 25℃","low":"低温 7℃","ymd":"2024-04-11","week":"星期四","sunrise":"05:41","sunset":"18:48","aqi":117,"fx":"南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 28℃","low":"低温 12℃","ymd":"2024-04-12","week":"星期五","sunrise":"05:39","sunset":"18:49","aqi":119,"fx":"南风","fl":"1级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"13","high":"高温 28℃","low":"低温 13℃","ymd":"2024-04-13","week":"星期六","sunrise":"05:38","sunset":"18:50","aqi":111,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"14","high":"高温 21℃","low":"低温 15℃","ymd":"2024-04-14","week":"星期日","sunrise":"05:36","sunset":"18:51","aqi":114,"fx":"东风","fl":"2级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"15","high":"高温 22℃","low":"低温 11℃","ymd":"2024-04-15","week":"星期一","sunrise":"05:35","sunset":"18:52","aqi":115,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","high":"高温 25℃","low":"低温 9℃","ymd":"2024-04-16","week":"星期二","sunrise":"05:33","sunset":"18:53","aqi":102,"fx":"北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"17","high":"高温 28℃","low":"低温 10℃","ymd":"2024-04-17","week":"星期三","sunrise":"05:32","sunset":"18:54","aqi":114,"fx":"东南风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","high":"高温 23℃","low":"低温 16℃","ymd":"2024-04-18","week":"星期四","sunrise":"05:30","sunset":"18:55","aqi":108,"fx":"西南风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"19","high":"高温 17℃","low":"低温 12℃","ymd":"2024-04-19","week":"星期五","sunrise":"05:29","sunset":"18:56","aqi":127,"fx":"南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"20","high":"高温 24℃","low":"低温 11℃","ymd":"2024-04-20","week":"星期六","sunrise":"05:28","sunset":"18:57","aqi":126,"fx":"西南风","fl":"1级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"21","high":"高温 26℃","low":"低温 15℃","ymd":"2024-04-21","week":"星期日","sunrise":"05:26","sunset":"18:58","aqi":100,"fx":"西南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"22","high":"高温 22℃","low":"低温 13℃","ymd":"2024-04-22","week":"星期一","sunrise":"05:25","sunset":"18:59","aqi":113,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
         * yesterday : {"date":"07","high":"高温 26℃","low":"低温 11℃","ymd":"2024-04-07","week":"星期日","sunrise":"05:47","sunset":"18:44","aqi":40,"fx":"西风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}
         */

        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 07
             * high : 高温 26℃
             * low : 低温 11℃
             * ymd : 2024-04-07
             * week : 星期日
             * sunrise : 05:47
             * sunset : 18:44
             * aqi : 40
             * fx : 西风
             * fl : 2级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 08
             * high : 高温 21℃
             * low : 低温 12℃
             * ymd : 2024-04-08
             * week : 星期一
             * sunrise : 05:45
             * sunset : 18:45
             * aqi : 125
             * fx : 东南风
             * fl : 3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
