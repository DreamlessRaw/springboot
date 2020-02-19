package com.example.demo.entity

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName("emp")
class Emp {
    @TableId("id")
    var id = 0
    var code = ""
    var name = ""
}