import com.example.myapplication.dto.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("/login")
    fun Login(@Body loginDTO: LoginDTO) : Call<String>

    @POST("/join")
    fun Signup(@Body signupDTO: SignupDTO) : Call<Boolean>

    @POST("/take-pill")
    fun TakePill(@Body typeDTO: TypeDTO) : Call<Boolean>

    @POST("/info-alarm")
    fun InfoAlarm(@Body typeDTO: TypeDTO): Call<List<medicine>>
}