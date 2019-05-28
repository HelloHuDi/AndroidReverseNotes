package com.tencent.mm.cd.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    int mStartPos = 0;
    SparseArray<Object> ych = new SparseArray();
    int yci;
    HashMap<Object, T> ycj = new HashMap();
    ArrayList<Object> yck;
    T ycl;

    public abstract ArrayList<T> ao(ArrayList<Object> arrayList);

    public abstract T dvz();

    /* Access modifiers changed, original: final */
    public final void b(Object obj, T t) {
        this.ycj.put(obj, t);
    }

    public final boolean MI(int i) {
        return this.ych.indexOfKey(i) >= 0;
    }

    public final void ha(int i, int i2) {
        if (i2 != 0) {
            ab.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
            this.ych.remove(i);
        } else if (this.ycl != null) {
            Object key = this.ycl.getKey();
            b(key, this.ycl);
            this.ych.put(i, key);
        }
    }

    public final void clearData() {
        ab.i("MicroMsg.CursorDataWindow", "clearData");
        this.ych.clear();
        this.ycj.clear();
    }

    /* Access modifiers changed, original: protected */
    public void onAllReferencesReleased() {
        clearData();
    }

    /* Access modifiers changed, original: final */
    public final void z(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.ych.size(); i2++) {
            int keyAt = this.ych.keyAt(i2);
            Object valueAt = this.ych.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                ab.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.ych.size() != sparseArray.size()) {
            ab.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.ych.size() + " newposistion Size : " + sparseArray.size());
        }
        this.ych = sparseArray;
    }

    public final boolean cK(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.ycj == null || !this.ycj.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.ycj != null && this.ycj.containsKey(obj);
    }
}
