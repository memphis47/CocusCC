package com.cocus.cocuscc.data.database.dao

import androidx.room.*
import com.cocus.cocuscc.data.database.model.SearchCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Dao
interface SearchDao {

    @Query("SELECT * FROM result")
    fun getResult(): Flow<List<SearchCache>>

    @Transaction
    suspend fun updateResult(users: SearchCache): Flow<Boolean> = flow {
        insert(users)
        deleteLastMember()
        emit(true)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: SearchCache)

    @Query("DELETE FROM result")
    suspend fun deleteAll()

    @Query("DELETE FROM result where id NOT IN (SELECT id from result ORDER BY id DESC LIMIT 5)")
    suspend fun deleteLastMember()
}