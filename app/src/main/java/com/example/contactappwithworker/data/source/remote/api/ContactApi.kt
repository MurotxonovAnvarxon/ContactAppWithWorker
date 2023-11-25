package com.example.contactappwithworker.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import com.example.contactappwithworker.data.source.remote.request.ContactRequest
import com.example.contactappwithworker.data.source.remote.response.ContactResponse
import com.example.contactappwithworker.data.source.remote.response.DeleteResponse

interface ContactApi {
    @GET("contact")
    suspend fun getContacts() : Response<List<ContactResponse>>

    @POST("contact")
    suspend fun addContact(@Body contactRequest: ContactRequest) : Response<ContactResponse>

    @PUT("contact")
    suspend fun updateContact(@Body contactRequest: ContactRequest) : Response<ContactResponse>

    @DELETE
    suspend fun deleteContact(@Query("id") id : Int) : Response<DeleteResponse>

}