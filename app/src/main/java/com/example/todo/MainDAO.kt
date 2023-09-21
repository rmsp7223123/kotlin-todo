package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * FROM tb_todo ORDER BY SEQ ASC")
    fun getTodoListAll(): LiveData<List<MainModel>>  //getAll 함수에 LiveData 를 반환

    @Insert(onConflict = OnConflictStrategy.REPLACE)  //@Insert 의 onConflict = : 중복된 데이터의 경우 어떻게 처리할 것인지에 대한 처리를 지정
    fun insert(todo: MainModel)

    @Delete
    fun delete(todo: MainModel)

}