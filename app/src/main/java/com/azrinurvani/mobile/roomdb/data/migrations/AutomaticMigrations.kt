package com.azrinurvani.mobile.roomdb.data.migrations

import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec
import androidx.sqlite.db.SupportSQLiteDatabase

@RenameColumn(
    tableName = "word_table",
    fromColumnName = "created",
    toColumnName = "createdDate"
)
class Migration1To2 : AutoMigrationSpec {
    override fun onPostMigrate(db: SupportSQLiteDatabase) {
        super.onPostMigrate(db)
    }
}