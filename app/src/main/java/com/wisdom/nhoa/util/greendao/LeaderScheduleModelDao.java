package com.wisdom.nhoa.util.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wisdom.nhoa.homepage.model.LeaderScheduleModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LEADER_SCHEDULE_MODEL".
*/
public class LeaderScheduleModelDao extends AbstractDao<LeaderScheduleModel, Void> {

    public static final String TABLENAME = "LEADER_SCHEDULE_MODEL";

    /**
     * Properties of entity LeaderScheduleModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Endtime = new Property(0, String.class, "endtime", false, "ENDTIME");
        public final static Property Calendarid = new Property(1, int.class, "calendarid", false, "CALENDARID");
        public final static Property Id = new Property(2, String.class, "id", false, "ID");
        public final static Property Username = new Property(3, String.class, "username", false, "USERNAME");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property Starttime = new Property(5, String.class, "starttime", false, "STARTTIME");
        public final static Property Ownername = new Property(6, String.class, "ownername", false, "OWNERNAME");
        public final static Property Datetxt = new Property(7, String.class, "datetxt", false, "DATETXT");
        public final static Property Isallday = new Property(8, boolean.class, "isallday", false, "ISALLDAY");
        public final static Property Location = new Property(9, String.class, "location", false, "LOCATION");
    }


    public LeaderScheduleModelDao(DaoConfig config) {
        super(config);
    }
    
    public LeaderScheduleModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LEADER_SCHEDULE_MODEL\" (" + //
                "\"ENDTIME\" TEXT," + // 0: endtime
                "\"CALENDARID\" INTEGER NOT NULL ," + // 1: calendarid
                "\"ID\" TEXT," + // 2: id
                "\"USERNAME\" TEXT," + // 3: username
                "\"TITLE\" TEXT," + // 4: title
                "\"STARTTIME\" TEXT," + // 5: starttime
                "\"OWNERNAME\" TEXT," + // 6: ownername
                "\"DATETXT\" TEXT," + // 7: datetxt
                "\"ISALLDAY\" INTEGER NOT NULL ," + // 8: isallday
                "\"LOCATION\" TEXT);"); // 9: location
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LEADER_SCHEDULE_MODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LeaderScheduleModel entity) {
        stmt.clearBindings();
 
        String endtime = entity.getEndtime();
        if (endtime != null) {
            stmt.bindString(1, endtime);
        }
        stmt.bindLong(2, entity.getCalendarid());
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(3, id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(4, username);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String starttime = entity.getStarttime();
        if (starttime != null) {
            stmt.bindString(6, starttime);
        }
 
        String ownername = entity.getOwnername();
        if (ownername != null) {
            stmt.bindString(7, ownername);
        }
 
        String datetxt = entity.getDatetxt();
        if (datetxt != null) {
            stmt.bindString(8, datetxt);
        }
        stmt.bindLong(9, entity.getIsallday() ? 1L: 0L);
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(10, location);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LeaderScheduleModel entity) {
        stmt.clearBindings();
 
        String endtime = entity.getEndtime();
        if (endtime != null) {
            stmt.bindString(1, endtime);
        }
        stmt.bindLong(2, entity.getCalendarid());
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(3, id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(4, username);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String starttime = entity.getStarttime();
        if (starttime != null) {
            stmt.bindString(6, starttime);
        }
 
        String ownername = entity.getOwnername();
        if (ownername != null) {
            stmt.bindString(7, ownername);
        }
 
        String datetxt = entity.getDatetxt();
        if (datetxt != null) {
            stmt.bindString(8, datetxt);
        }
        stmt.bindLong(9, entity.getIsallday() ? 1L: 0L);
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(10, location);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public LeaderScheduleModel readEntity(Cursor cursor, int offset) {
        LeaderScheduleModel entity = new LeaderScheduleModel( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // endtime
            cursor.getInt(offset + 1), // calendarid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // username
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // title
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // starttime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // ownername
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // datetxt
            cursor.getShort(offset + 8) != 0, // isallday
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // location
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LeaderScheduleModel entity, int offset) {
        entity.setEndtime(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCalendarid(cursor.getInt(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUsername(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setStarttime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOwnername(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDatetxt(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIsallday(cursor.getShort(offset + 8) != 0);
        entity.setLocation(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(LeaderScheduleModel entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(LeaderScheduleModel entity) {
        return null;
    }

    @Override
    public boolean hasKey(LeaderScheduleModel entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
