package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_todo")  //@Entity 의 tableName = : 테이블명 지정
data class MainModel(

    @PrimaryKey(autoGenerate = true)  //@PrimaryKey 의 autoGenerate = : null 을 받으면 id 값을 자동으로 할당해준다
    var id: Long?,

    @ColumnInfo(name = "seq")  //@ColumnInfo : 컬럼명 지정. 컬럼명을 변수명과 같이 쓰려면 생략 가능
    var seq: Int,

    @ColumnInfo(name = "title")  //@ColumnInfo : 컬럼명 지정. 컬럼명을 변수명과 같이 쓰려면 생략 가능
    var title: String,

    @ColumnInfo(name = "content")  //@ColumnInfo : 컬럼명 지정. 컬럼명을 변수명과 같이 쓰려면 생략 가능
    var content: String,

    @ColumnInfo(name = "createDate")  //@ColumnInfo : 컬럼명 지정. 컬럼명을 변수명과 같이 쓰려면 생략 가능
    var createDate: Long

) {
    constructor() : this(null, 0, "", "", -1);
}