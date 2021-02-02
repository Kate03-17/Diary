package com.example.diary

import android.app.Application

class App: Application() {
    val notes = mutableListOf<Note>()
}