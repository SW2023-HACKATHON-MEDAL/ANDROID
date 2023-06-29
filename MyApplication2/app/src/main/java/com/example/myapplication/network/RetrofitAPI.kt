import com.example.myapplication.dto.LoginDTO
import com.example.myapplication.dto.LoginResponseDTO
import com.example.myapplication.dto.SignupDTO
import com.example.myapplication.dto.SignupResponseDTO
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
}