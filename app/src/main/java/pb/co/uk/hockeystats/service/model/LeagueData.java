package pb.co.uk.hockeystats.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueData {

    @SerializedName("virtual")
    @Expose
    public String virtual;
    @SerializedName("gameType")
    @Expose
    public String gameType;
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("hideParentLeagueName")
    @Expose
    public String hideParentLeagueName;
    @SerializedName("hasChildLeagues")
    @Expose
    public String hasChildLeagues;
    @SerializedName("teamClass")
    @Expose
    public String teamClass;
    @SerializedName("country")
    @Expose
    public Country country;
    @SerializedName("playerLevel")
    @Expose
    public String playerLevel;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("teamType")
    @Expose
    public String teamType;
    @SerializedName("fullName")
    @Expose
    public String fullName;
    @SerializedName("searchable")
    @Expose
    public String searchable;
}
