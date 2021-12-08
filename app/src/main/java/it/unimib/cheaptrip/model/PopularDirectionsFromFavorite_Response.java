package it.unimib.cheaptrip.model;

import java.util.List;

public class PopularDirectionsFromFavorite_Response {

    private String success;
    private List<PopularDirectionsFromFavorite> options;

    public PopularDirectionsFromFavorite_Response(String success, List<PopularDirectionsFromFavorite> options) {
        this.success = success;
        this.options = options;
    }

    public PopularDirectionsFromFavorite_Response() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<PopularDirectionsFromFavorite> getOptions() {
        return options;
    }

    public void setOptions(List<PopularDirectionsFromFavorite> options) {
        this.options = options;
    }


    @Override
    public String toString() {
        return "PopularDirectionsFromFavorite_Response{" +
                "success='" + success + '\'' +
                ", options=" + options +
                '}';
    }


}
