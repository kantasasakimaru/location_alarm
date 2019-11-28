package com.example.locationalarmproject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Schedule  : RealmObject(){
    @PrimaryKey
    var id: Long = 0
    var date: Date = Date()
    var date2: Date = Date()
    var title: String = ""
    var detail: String = ""
    var address: String =""


}