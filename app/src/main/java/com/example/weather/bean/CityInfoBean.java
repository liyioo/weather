package com.example.weather.bean;

import java.util.List;

public class CityInfoBean {


    /**
     * status : ok
     * query : 北京
     * places : [{"formatted_address":"北京市","id":"CN_110000","place_id":"CN_110000","name":"北京市","location":{"lat":39.904179,"lng":116.407387}},{"formatted_address":"北京市北京城区","id":"CN_110100","place_id":"CN_110100","name":"北京城区","location":{"lat":39.904989,"lng":116.405285}},{"formatted_address":"北京市","id":"CN_110000","place_id":"CN_110000","name":"北京市","location":{"lat":39.904179,"lng":116.407387}},{"formatted_address":"北京市北京城区","id":"CN_110100","place_id":"CN_110100","name":"北京城区","location":{"lat":39.904989,"lng":116.405285}},{"formatted_address":"北京市北京城区东城区","id":"CN_110101","place_id":"CN_110101","name":"东城区","location":{"lat":39.928359,"lng":116.416334}}]
     */

    private String status;
    private String query;
    private List<PlacesBean> places;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<PlacesBean> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlacesBean> places) {
        this.places = places;
    }

    public static class PlacesBean {
        /**
         * formatted_address : 北京市
         * id : CN_110000
         * place_id : CN_110000
         * name : 北京市
         * location : {"lat":39.904179,"lng":116.407387}
         */

        private String formatted_address;
        private String id;
        private String place_id;
        private String name;
        private LocationBean location;

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public static class LocationBean {
            /**
             * lat : 39.904179
             * lng : 116.407387
             */

            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }
    }
}
