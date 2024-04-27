package com.example.weather.bean;

import java.util.List;

public class weatherNowBean {


    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Shanghai
     * server_time : 1712669264
     * location : [39.865246,116.378517]
     * result : {"daily":{"status":"ok","astro":[{"date":"2024-04-09T00:00+08:00","sunrise":{"time":"05:45"},"sunset":{"time":"18:46"}},{"date":"2024-04-10T00:00+08:00","sunrise":{"time":"05:43"},"sunset":{"time":"18:47"}},{"date":"2024-04-11T00:00+08:00","sunrise":{"time":"05:42"},"sunset":{"time":"18:48"}},{"date":"2024-04-12T00:00+08:00","sunrise":{"time":"05:40"},"sunset":{"time":"18:49"}},{"date":"2024-04-13T00:00+08:00","sunrise":{"time":"05:39"},"sunset":{"time":"18:50"}}],"precipitation":[{"date":"2024-04-09T00:00+08:00","max":0.0851,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":0.1774,"min":0,"avg":0.0245},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-13T00:00+08:00","max":0,"min":0,"avg":0}],"temperature":[{"date":"2024-04-09T00:00+08:00","max":17.64,"min":9.6,"avg":10.86},{"date":"2024-04-10T00:00+08:00","max":10.73,"min":6.83,"avg":7.89},{"date":"2024-04-11T00:00+08:00","max":22.26,"min":4.23,"avg":13.01},{"date":"2024-04-12T00:00+08:00","max":27.13,"min":9.2,"avg":17.99},{"date":"2024-04-13T00:00+08:00","max":27.29,"min":11.5,"avg":19.54}],"wind":[{"date":"2024-04-09T00:00+08:00","max":{"speed":20.11,"direction":186.69},"min":{"speed":6.77,"direction":145.23},"avg":{"speed":13.85,"direction":175.58}},{"date":"2024-04-10T00:00+08:00","max":{"speed":10.1,"direction":19.4},"min":{"speed":0.49,"direction":84.92},"avg":{"speed":4.11,"direction":92.63}},{"date":"2024-04-11T00:00+08:00","max":{"speed":15.88,"direction":204.62},"min":{"speed":0.21,"direction":158.75},"avg":{"speed":6.71,"direction":196.93}},{"date":"2024-04-12T00:00+08:00","max":{"speed":21.05,"direction":203.64},"min":{"speed":3.1,"direction":169.49},"avg":{"speed":11.06,"direction":208.1}},{"date":"2024-04-13T00:00+08:00","max":{"speed":21.06,"direction":188.19},"min":{"speed":5.7,"direction":158.16},"avg":{"speed":12.75,"direction":180.8}}],"humidity":[{"date":"2024-04-09T00:00+08:00","max":0.48,"min":0.21,"avg":0.26},{"date":"2024-04-10T00:00+08:00","max":0.76,"min":0.22,"avg":0.47},{"date":"2024-04-11T00:00+08:00","max":0.8,"min":0.28,"avg":0.53},{"date":"2024-04-12T00:00+08:00","max":0.67,"min":0.21,"avg":0.42},{"date":"2024-04-13T00:00+08:00","max":0.61,"min":0.29,"avg":0.43}],"cloudrate":[{"date":"2024-04-09T00:00+08:00","max":1,"min":0,"avg":0.5},{"date":"2024-04-10T00:00+08:00","max":1,"min":0,"avg":0.65},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0.78,"min":0,"avg":0.45},{"date":"2024-04-13T00:00+08:00","max":1,"min":0,"avg":0.39}],"pressure":[{"date":"2024-04-09T00:00+08:00","max":102028.37,"min":101334.11,"avg":101522.31},{"date":"2024-04-10T00:00+08:00","max":101507.9,"min":100888.63,"avg":101194.39},{"date":"2024-04-11T00:00+08:00","max":100985.1,"min":100300.66,"avg":100669.24},{"date":"2024-04-12T00:00+08:00","max":100545.95,"min":99979.81,"avg":100295.4},{"date":"2024-04-13T00:00+08:00","max":100673.49,"min":100189.49,"avg":100426.43}],"visibility":[{"date":"2024-04-09T00:00+08:00","max":26.3,"min":23.27,"avg":26.3},{"date":"2024-04-10T00:00+08:00","max":26.3,"min":6.81,"avg":17.59},{"date":"2024-04-11T00:00+08:00","max":10.12,"min":4.17,"avg":7.68},{"date":"2024-04-12T00:00+08:00","max":11.43,"min":6.92,"avg":8.76},{"date":"2024-04-13T00:00+08:00","max":26.3,"min":8.22,"avg":14.05}],"dswrf":[{"date":"2024-04-09T00:00+08:00","max":728.9,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":256.8,"min":0,"avg":87.2},{"date":"2024-04-11T00:00+08:00","max":748.6,"min":0,"avg":293.4},{"date":"2024-04-12T00:00+08:00","max":724.6,"min":0,"avg":284.2},{"date":"2024-04-13T00:00+08:00","max":683.2,"min":0,"avg":245.6}],"air_quality":{"aqi":[{"date":"2024-04-09T00:00+08:00","max":{"chn":89,"usa":156},"avg":{"chn":41,"usa":86},"min":{"chn":37,"usa":61}},{"date":"2024-04-10T00:00+08:00","max":{"chn":75,"usa":149},"avg":{"chn":61,"usa":123},"min":{"chn":40,"usa":84}},{"date":"2024-04-11T00:00+08:00","max":{"chn":90,"usa":156},"avg":{"chn":81,"usa":153},"min":{"chn":75,"usa":149}},{"date":"2024-04-12T00:00+08:00","max":{"chn":91,"usa":157},"avg":{"chn":82,"usa":152},"min":{"chn":72,"usa":144}},{"date":"2024-04-13T00:00+08:00","max":{"chn":83,"usa":154},"avg":{"chn":69,"usa":136},"min":{"chn":41,"usa":86}}],"pm25":[{"date":"2024-04-09T00:00+08:00","max":66,"avg":29,"min":17},{"date":"2024-04-10T00:00+08:00","max":55,"avg":44,"min":28},{"date":"2024-04-11T00:00+08:00","max":67,"avg":59,"min":55},{"date":"2024-04-12T00:00+08:00","max":68,"avg":60,"min":53},{"date":"2024-04-13T00:00+08:00","max":62,"avg":50,"min":29}]},"skycon":[{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2024-04-09T00:00+08:00","value":"CLOUDY"},{"date":"2024-04-10T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_20h_32h":[{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-12T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-13T00:00+08:00","value":"CLOUDY"}],"life_index":{"ultraviolet":[{"date":"2024-04-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"强"},{"date":"2024-04-12T00:00+08:00","index":"3","desc":"中等"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2024-04-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-11T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-12T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-13T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2024-04-09T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-10T00:00+08:00","index":"6","desc":"冷"},{"date":"2024-04-11T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"comfort":[{"date":"2024-04-09T00:00+08:00","index":"7","desc":"冷"},{"date":"2024-04-10T00:00+08:00","index":"8","desc":"很冷"},{"date":"2024-04-11T00:00+08:00","index":"6","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"coldRisk":[{"date":"2024-04-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"极易发"}]}},"primary":0}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private int server_time;
    private ResultBean result;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * daily : {"status":"ok","astro":[{"date":"2024-04-09T00:00+08:00","sunrise":{"time":"05:45"},"sunset":{"time":"18:46"}},{"date":"2024-04-10T00:00+08:00","sunrise":{"time":"05:43"},"sunset":{"time":"18:47"}},{"date":"2024-04-11T00:00+08:00","sunrise":{"time":"05:42"},"sunset":{"time":"18:48"}},{"date":"2024-04-12T00:00+08:00","sunrise":{"time":"05:40"},"sunset":{"time":"18:49"}},{"date":"2024-04-13T00:00+08:00","sunrise":{"time":"05:39"},"sunset":{"time":"18:50"}}],"precipitation":[{"date":"2024-04-09T00:00+08:00","max":0.0851,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":0.1774,"min":0,"avg":0.0245},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-13T00:00+08:00","max":0,"min":0,"avg":0}],"temperature":[{"date":"2024-04-09T00:00+08:00","max":17.64,"min":9.6,"avg":10.86},{"date":"2024-04-10T00:00+08:00","max":10.73,"min":6.83,"avg":7.89},{"date":"2024-04-11T00:00+08:00","max":22.26,"min":4.23,"avg":13.01},{"date":"2024-04-12T00:00+08:00","max":27.13,"min":9.2,"avg":17.99},{"date":"2024-04-13T00:00+08:00","max":27.29,"min":11.5,"avg":19.54}],"wind":[{"date":"2024-04-09T00:00+08:00","max":{"speed":20.11,"direction":186.69},"min":{"speed":6.77,"direction":145.23},"avg":{"speed":13.85,"direction":175.58}},{"date":"2024-04-10T00:00+08:00","max":{"speed":10.1,"direction":19.4},"min":{"speed":0.49,"direction":84.92},"avg":{"speed":4.11,"direction":92.63}},{"date":"2024-04-11T00:00+08:00","max":{"speed":15.88,"direction":204.62},"min":{"speed":0.21,"direction":158.75},"avg":{"speed":6.71,"direction":196.93}},{"date":"2024-04-12T00:00+08:00","max":{"speed":21.05,"direction":203.64},"min":{"speed":3.1,"direction":169.49},"avg":{"speed":11.06,"direction":208.1}},{"date":"2024-04-13T00:00+08:00","max":{"speed":21.06,"direction":188.19},"min":{"speed":5.7,"direction":158.16},"avg":{"speed":12.75,"direction":180.8}}],"humidity":[{"date":"2024-04-09T00:00+08:00","max":0.48,"min":0.21,"avg":0.26},{"date":"2024-04-10T00:00+08:00","max":0.76,"min":0.22,"avg":0.47},{"date":"2024-04-11T00:00+08:00","max":0.8,"min":0.28,"avg":0.53},{"date":"2024-04-12T00:00+08:00","max":0.67,"min":0.21,"avg":0.42},{"date":"2024-04-13T00:00+08:00","max":0.61,"min":0.29,"avg":0.43}],"cloudrate":[{"date":"2024-04-09T00:00+08:00","max":1,"min":0,"avg":0.5},{"date":"2024-04-10T00:00+08:00","max":1,"min":0,"avg":0.65},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0.78,"min":0,"avg":0.45},{"date":"2024-04-13T00:00+08:00","max":1,"min":0,"avg":0.39}],"pressure":[{"date":"2024-04-09T00:00+08:00","max":102028.37,"min":101334.11,"avg":101522.31},{"date":"2024-04-10T00:00+08:00","max":101507.9,"min":100888.63,"avg":101194.39},{"date":"2024-04-11T00:00+08:00","max":100985.1,"min":100300.66,"avg":100669.24},{"date":"2024-04-12T00:00+08:00","max":100545.95,"min":99979.81,"avg":100295.4},{"date":"2024-04-13T00:00+08:00","max":100673.49,"min":100189.49,"avg":100426.43}],"visibility":[{"date":"2024-04-09T00:00+08:00","max":26.3,"min":23.27,"avg":26.3},{"date":"2024-04-10T00:00+08:00","max":26.3,"min":6.81,"avg":17.59},{"date":"2024-04-11T00:00+08:00","max":10.12,"min":4.17,"avg":7.68},{"date":"2024-04-12T00:00+08:00","max":11.43,"min":6.92,"avg":8.76},{"date":"2024-04-13T00:00+08:00","max":26.3,"min":8.22,"avg":14.05}],"dswrf":[{"date":"2024-04-09T00:00+08:00","max":728.9,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":256.8,"min":0,"avg":87.2},{"date":"2024-04-11T00:00+08:00","max":748.6,"min":0,"avg":293.4},{"date":"2024-04-12T00:00+08:00","max":724.6,"min":0,"avg":284.2},{"date":"2024-04-13T00:00+08:00","max":683.2,"min":0,"avg":245.6}],"air_quality":{"aqi":[{"date":"2024-04-09T00:00+08:00","max":{"chn":89,"usa":156},"avg":{"chn":41,"usa":86},"min":{"chn":37,"usa":61}},{"date":"2024-04-10T00:00+08:00","max":{"chn":75,"usa":149},"avg":{"chn":61,"usa":123},"min":{"chn":40,"usa":84}},{"date":"2024-04-11T00:00+08:00","max":{"chn":90,"usa":156},"avg":{"chn":81,"usa":153},"min":{"chn":75,"usa":149}},{"date":"2024-04-12T00:00+08:00","max":{"chn":91,"usa":157},"avg":{"chn":82,"usa":152},"min":{"chn":72,"usa":144}},{"date":"2024-04-13T00:00+08:00","max":{"chn":83,"usa":154},"avg":{"chn":69,"usa":136},"min":{"chn":41,"usa":86}}],"pm25":[{"date":"2024-04-09T00:00+08:00","max":66,"avg":29,"min":17},{"date":"2024-04-10T00:00+08:00","max":55,"avg":44,"min":28},{"date":"2024-04-11T00:00+08:00","max":67,"avg":59,"min":55},{"date":"2024-04-12T00:00+08:00","max":68,"avg":60,"min":53},{"date":"2024-04-13T00:00+08:00","max":62,"avg":50,"min":29}]},"skycon":[{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_08h_20h":[{"date":"2024-04-09T00:00+08:00","value":"CLOUDY"},{"date":"2024-04-10T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}],"skycon_20h_32h":[{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-12T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-13T00:00+08:00","value":"CLOUDY"}],"life_index":{"ultraviolet":[{"date":"2024-04-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"强"},{"date":"2024-04-12T00:00+08:00","index":"3","desc":"中等"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2024-04-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-11T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-12T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-13T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2024-04-09T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-10T00:00+08:00","index":"6","desc":"冷"},{"date":"2024-04-11T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"comfort":[{"date":"2024-04-09T00:00+08:00","index":"7","desc":"冷"},{"date":"2024-04-10T00:00+08:00","index":"8","desc":"很冷"},{"date":"2024-04-11T00:00+08:00","index":"6","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"coldRisk":[{"date":"2024-04-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"极易发"}]}}
         * primary : 0
         */

        private DailyBean daily;
        private int primary;

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class DailyBean {
            /**
             * status : ok
             * astro : [{"date":"2024-04-09T00:00+08:00","sunrise":{"time":"05:45"},"sunset":{"time":"18:46"}},{"date":"2024-04-10T00:00+08:00","sunrise":{"time":"05:43"},"sunset":{"time":"18:47"}},{"date":"2024-04-11T00:00+08:00","sunrise":{"time":"05:42"},"sunset":{"time":"18:48"}},{"date":"2024-04-12T00:00+08:00","sunrise":{"time":"05:40"},"sunset":{"time":"18:49"}},{"date":"2024-04-13T00:00+08:00","sunrise":{"time":"05:39"},"sunset":{"time":"18:50"}}]
             * precipitation : [{"date":"2024-04-09T00:00+08:00","max":0.0851,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":0.1774,"min":0,"avg":0.0245},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-13T00:00+08:00","max":0,"min":0,"avg":0}]
             * temperature : [{"date":"2024-04-09T00:00+08:00","max":17.64,"min":9.6,"avg":10.86},{"date":"2024-04-10T00:00+08:00","max":10.73,"min":6.83,"avg":7.89},{"date":"2024-04-11T00:00+08:00","max":22.26,"min":4.23,"avg":13.01},{"date":"2024-04-12T00:00+08:00","max":27.13,"min":9.2,"avg":17.99},{"date":"2024-04-13T00:00+08:00","max":27.29,"min":11.5,"avg":19.54}]
             * wind : [{"date":"2024-04-09T00:00+08:00","max":{"speed":20.11,"direction":186.69},"min":{"speed":6.77,"direction":145.23},"avg":{"speed":13.85,"direction":175.58}},{"date":"2024-04-10T00:00+08:00","max":{"speed":10.1,"direction":19.4},"min":{"speed":0.49,"direction":84.92},"avg":{"speed":4.11,"direction":92.63}},{"date":"2024-04-11T00:00+08:00","max":{"speed":15.88,"direction":204.62},"min":{"speed":0.21,"direction":158.75},"avg":{"speed":6.71,"direction":196.93}},{"date":"2024-04-12T00:00+08:00","max":{"speed":21.05,"direction":203.64},"min":{"speed":3.1,"direction":169.49},"avg":{"speed":11.06,"direction":208.1}},{"date":"2024-04-13T00:00+08:00","max":{"speed":21.06,"direction":188.19},"min":{"speed":5.7,"direction":158.16},"avg":{"speed":12.75,"direction":180.8}}]
             * humidity : [{"date":"2024-04-09T00:00+08:00","max":0.48,"min":0.21,"avg":0.26},{"date":"2024-04-10T00:00+08:00","max":0.76,"min":0.22,"avg":0.47},{"date":"2024-04-11T00:00+08:00","max":0.8,"min":0.28,"avg":0.53},{"date":"2024-04-12T00:00+08:00","max":0.67,"min":0.21,"avg":0.42},{"date":"2024-04-13T00:00+08:00","max":0.61,"min":0.29,"avg":0.43}]
             * cloudrate : [{"date":"2024-04-09T00:00+08:00","max":1,"min":0,"avg":0.5},{"date":"2024-04-10T00:00+08:00","max":1,"min":0,"avg":0.65},{"date":"2024-04-11T00:00+08:00","max":0,"min":0,"avg":0},{"date":"2024-04-12T00:00+08:00","max":0.78,"min":0,"avg":0.45},{"date":"2024-04-13T00:00+08:00","max":1,"min":0,"avg":0.39}]
             * pressure : [{"date":"2024-04-09T00:00+08:00","max":102028.37,"min":101334.11,"avg":101522.31},{"date":"2024-04-10T00:00+08:00","max":101507.9,"min":100888.63,"avg":101194.39},{"date":"2024-04-11T00:00+08:00","max":100985.1,"min":100300.66,"avg":100669.24},{"date":"2024-04-12T00:00+08:00","max":100545.95,"min":99979.81,"avg":100295.4},{"date":"2024-04-13T00:00+08:00","max":100673.49,"min":100189.49,"avg":100426.43}]
             * visibility : [{"date":"2024-04-09T00:00+08:00","max":26.3,"min":23.27,"avg":26.3},{"date":"2024-04-10T00:00+08:00","max":26.3,"min":6.81,"avg":17.59},{"date":"2024-04-11T00:00+08:00","max":10.12,"min":4.17,"avg":7.68},{"date":"2024-04-12T00:00+08:00","max":11.43,"min":6.92,"avg":8.76},{"date":"2024-04-13T00:00+08:00","max":26.3,"min":8.22,"avg":14.05}]
             * dswrf : [{"date":"2024-04-09T00:00+08:00","max":728.9,"min":0,"avg":0},{"date":"2024-04-10T00:00+08:00","max":256.8,"min":0,"avg":87.2},{"date":"2024-04-11T00:00+08:00","max":748.6,"min":0,"avg":293.4},{"date":"2024-04-12T00:00+08:00","max":724.6,"min":0,"avg":284.2},{"date":"2024-04-13T00:00+08:00","max":683.2,"min":0,"avg":245.6}]
             * air_quality : {"aqi":[{"date":"2024-04-09T00:00+08:00","max":{"chn":89,"usa":156},"avg":{"chn":41,"usa":86},"min":{"chn":37,"usa":61}},{"date":"2024-04-10T00:00+08:00","max":{"chn":75,"usa":149},"avg":{"chn":61,"usa":123},"min":{"chn":40,"usa":84}},{"date":"2024-04-11T00:00+08:00","max":{"chn":90,"usa":156},"avg":{"chn":81,"usa":153},"min":{"chn":75,"usa":149}},{"date":"2024-04-12T00:00+08:00","max":{"chn":91,"usa":157},"avg":{"chn":82,"usa":152},"min":{"chn":72,"usa":144}},{"date":"2024-04-13T00:00+08:00","max":{"chn":83,"usa":154},"avg":{"chn":69,"usa":136},"min":{"chn":41,"usa":86}}],"pm25":[{"date":"2024-04-09T00:00+08:00","max":66,"avg":29,"min":17},{"date":"2024-04-10T00:00+08:00","max":55,"avg":44,"min":28},{"date":"2024-04-11T00:00+08:00","max":67,"avg":59,"min":55},{"date":"2024-04-12T00:00+08:00","max":68,"avg":60,"min":53},{"date":"2024-04-13T00:00+08:00","max":62,"avg":50,"min":29}]}
             * skycon : [{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}]
             * skycon_08h_20h : [{"date":"2024-04-09T00:00+08:00","value":"CLOUDY"},{"date":"2024-04-10T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_DAY"},{"date":"2024-04-12T00:00+08:00","value":"PARTLY_CLOUDY_DAY"},{"date":"2024-04-13T00:00+08:00","value":"PARTLY_CLOUDY_DAY"}]
             * skycon_20h_32h : [{"date":"2024-04-09T00:00+08:00","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2024-04-10T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-11T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-12T00:00+08:00","value":"CLEAR_NIGHT"},{"date":"2024-04-13T00:00+08:00","value":"CLOUDY"}]
             * life_index : {"ultraviolet":[{"date":"2024-04-09T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-10T00:00+08:00","index":"1","desc":"最弱"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"强"},{"date":"2024-04-12T00:00+08:00","index":"3","desc":"中等"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"强"}],"carWashing":[{"date":"2024-04-09T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2024-04-11T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-12T00:00+08:00","index":"2","desc":"较适宜"},{"date":"2024-04-13T00:00+08:00","index":"2","desc":"较适宜"}],"dressing":[{"date":"2024-04-09T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-10T00:00+08:00","index":"6","desc":"冷"},{"date":"2024-04-11T00:00+08:00","index":"5","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"comfort":[{"date":"2024-04-09T00:00+08:00","index":"7","desc":"冷"},{"date":"2024-04-10T00:00+08:00","index":"8","desc":"很冷"},{"date":"2024-04-11T00:00+08:00","index":"6","desc":"凉爽"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"温暖"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"温暖"}],"coldRisk":[{"date":"2024-04-09T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-10T00:00+08:00","index":"3","desc":"易发"},{"date":"2024-04-11T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-12T00:00+08:00","index":"4","desc":"极易发"},{"date":"2024-04-13T00:00+08:00","index":"4","desc":"极易发"}]}
             */

            private String status;
            private AirQualityBean air_quality;
            private LifeIndexBean life_index;
            private List<AstroBean> astro;
            private List<PrecipitationBean> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBean> wind;
            private List<HumidityBean> humidity;
            private List<CloudrateBean> cloudrate;
            private List<PressureBean> pressure;
            private List<VisibilityBean> visibility;
            private List<DswrfBean> dswrf;
            private List<SkyconBean> skycon;
            private List<Skycon08h20hBean> skycon_08h_20h;
            private List<Skycon20h32hBean> skycon_20h_32h;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<PressureBean> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureBean> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<Skycon08h20hBean> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<Skycon08h20hBean> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public List<Skycon20h32hBean> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<Skycon20h32hBean> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
            }

            public static class AirQualityBean {
                private List<AqiBean> aqi;
                private List<Pm25Bean> pm25;

                public List<AqiBean> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBean> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * max : {"chn":89,"usa":156}
                     * avg : {"chn":41,"usa":86}
                     * min : {"chn":37,"usa":61}
                     */

                    private String date;
                    private MaxBean max;
                    private AvgBean avg;
                    private MinBean min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public MaxBean getMax() {
                        return max;
                    }

                    public void setMax(MaxBean max) {
                        this.max = max;
                    }

                    public AvgBean getAvg() {
                        return avg;
                    }

                    public void setAvg(AvgBean avg) {
                        this.avg = avg;
                    }

                    public MinBean getMin() {
                        return min;
                    }

                    public void setMin(MinBean min) {
                        this.min = min;
                    }

                    public static class MaxBean {
                        /**
                         * chn : 89
                         * usa : 156
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class AvgBean {
                        /**
                         * chn : 41
                         * usa : 86
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class MinBean {
                        /**
                         * chn : 37
                         * usa : 61
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25Bean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * max : 66
                     * avg : 29
                     * min : 17
                     */

                    private String date;
                    private int max;
                    private int avg;
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public int getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public int getAvg() {
                        return avg;
                    }

                    public void setAvg(int avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }
            }

            public static class LifeIndexBean {
                private List<UltravioletBean> ultraviolet;
                private List<CarWashingBean> carWashing;
                private List<DressingBean> dressing;
                private List<ComfortBean> comfort;
                private List<ColdRiskBean> coldRisk;

                public List<UltravioletBean> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<CarWashingBean> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<CarWashingBean> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<DressingBean> getDressing() {
                    return dressing;
                }

                public void setDressing(List<DressingBean> dressing) {
                    this.dressing = dressing;
                }

                public List<ComfortBean> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortBean> comfort) {
                    this.comfort = comfort;
                }

                public List<ColdRiskBean> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskBean> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public static class UltravioletBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * index : 1
                     * desc : 最弱
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class CarWashingBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * index : 3
                     * desc : 较不适宜
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DressingBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * index : 5
                     * desc : 凉爽
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * index : 7
                     * desc : 冷
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdRiskBean {
                    /**
                     * date : 2024-04-09T00:00+08:00
                     * index : 4
                     * desc : 极易发
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class AstroBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * sunrise : {"time":"05:45"}
                 * sunset : {"time":"18:46"}
                 */

                private String date;
                private SunriseBean sunrise;
                private SunsetBean sunset;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public static class SunriseBean {
                    /**
                     * time : 05:45
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunsetBean {
                    /**
                     * time : 18:46
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 0.0851
                 * min : 0.0
                 * avg : 0.0
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class TemperatureBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 17.64
                 * min : 9.6
                 * avg : 10.86
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class WindBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : {"speed":20.11,"direction":186.69}
                 * min : {"speed":6.77,"direction":145.23}
                 * avg : {"speed":13.85,"direction":175.58}
                 */

                private String date;
                private MaxBeanX max;
                private MinBeanX min;
                private AvgBeanX avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBeanX getMax() {
                    return max;
                }

                public void setMax(MaxBeanX max) {
                    this.max = max;
                }

                public MinBeanX getMin() {
                    return min;
                }

                public void setMin(MinBeanX min) {
                    this.min = min;
                }

                public AvgBeanX getAvg() {
                    return avg;
                }

                public void setAvg(AvgBeanX avg) {
                    this.avg = avg;
                }

                public static class MaxBeanX {
                    /**
                     * speed : 20.11
                     * direction : 186.69
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class MinBeanX {
                    /**
                     * speed : 6.77
                     * direction : 145.23
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class AvgBeanX {
                    /**
                     * speed : 13.85
                     * direction : 175.58
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }
            }

            public static class HumidityBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 0.48
                 * min : 0.21
                 * avg : 0.26
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class CloudrateBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 1.0
                 * min : 0.0
                 * avg : 0.5
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class PressureBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 102028.37
                 * min : 101334.11
                 * avg : 101522.31
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class VisibilityBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 26.3
                 * min : 23.27
                 * avg : 26.3
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class DswrfBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * max : 728.9
                 * min : 0.0
                 * avg : 0.0
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class SkyconBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * value : PARTLY_CLOUDY_NIGHT
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon08h20hBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon20h32hBean {
                /**
                 * date : 2024-04-09T00:00+08:00
                 * value : PARTLY_CLOUDY_NIGHT
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
