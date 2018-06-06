package pb.co.uk.hockeystats.network;

import pb.co.uk.hockeystats.data.League;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andreas_himself on 21/03/2018.
 */

public interface LeagueService {
    @GET("GET /leagues/{id}/leagues")
    Call<League> getLeague(@Path("id") Long id);
}
