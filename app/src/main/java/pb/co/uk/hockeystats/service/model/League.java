package pb.co.uk.hockeystats.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andreas_himself on 21/03/2018.
 */

public class League {

    @SerializedName("data")
    @Expose
    public LeagueData data;

}
