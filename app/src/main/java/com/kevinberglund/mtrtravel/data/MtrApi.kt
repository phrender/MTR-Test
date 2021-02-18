package com.kevinberglund.mtrtravel.data

import com.kevinberglund.mtrtravel.data.entity.StationEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MtrApi {

    @Headers("Content-Type: text/plain")
    @POST("data.json")
    fun getSocTimeTable(@Body body: String = """<REQUEST> <LOGIN authenticationkey="082243d0be3a431596c23da94f2e3d7f" /> <QUERY objecttype="TrainAnnouncement" schemaversion="1.6" orderby="AdvertisedTimeAtLocation"> <FILTER> <AND> <EQ name="ActivityType" value="Avgang" />  <EQ name="LocationSignature" value="Söc" />  <EQ name="InformationOwner" value="SL" /> <GT name="AdvertisedTimeAtLocation" value=\uFF24dateadd(00:00:00)" /> <LT name="AdvertisedTimeAtLocation" value="\uFF24dateadd(01:00:00)" /> </AND> </FILTER> </QUERY> </REQUEST>"""): Call<StationEntity>

}