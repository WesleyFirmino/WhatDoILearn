package com.devventurus.whatdoilearn.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devventurus.whatdoilearn.entities.LearnedItem
import com.devventurus.whatdoilearn.entities.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LearnedItemDataBase : RoomDatabase() {

    abstract fun learnedItemDao() : LearnedItemDao

    //Singleton para não permitir o instanciamento do banco de dados em mais de um local ou gerar duplicidade
    companion object {
        @Volatile
        var INSTANCE: LearnedItemDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LearnedItemDataBase {
            return INSTANCE ?: synchronized(this){
                val dataBase = Room.databaseBuilder(
                    context.applicationContext,
                    LearnedItemDataBase::class.java,
                    "learned_item_database")
                    .addCallback(LearnedItemDatabadeCallback(scope))
                    .build()

                INSTANCE = dataBase
                dataBase
            }
        }
    }

    private class LearnedItemDatabadeCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.learnedItemDao())
                }
            }
        }

        private fun populateDatabase(learnedItemDao: LearnedItemDao) {
            val items = getAll()
            learnedItemDao.insert(items)
        }

        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(name = "Kotlin", description = "Linguagem kotlin para Android", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "RecyclerView", description = "Listas em Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "DataClass", description = "Kotlin data Class", understandingLevel = UnderstandingLevel.LOW),
                LearnedItem(name = "Life Cycle", description = "Ciclo de vida de uma aplicação Android", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "Intent", description = "Como usar intents", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Services", description = "Service em  Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Content Provider", description = "Dados com Contenct Provider", understandingLevel = UnderstandingLevel.LOW),
            )
        }
    }
}