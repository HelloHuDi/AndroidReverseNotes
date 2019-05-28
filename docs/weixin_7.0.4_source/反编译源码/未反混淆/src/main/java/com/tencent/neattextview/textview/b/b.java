package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle> implements Serializable {
    protected LinkedList<RectF> AjV;
    public CharacterStyle AjW;
    private int Ls;
    private int aqm;

    public abstract void a(Canvas canvas, TextPaint textPaint, List<d> list);

    b(int i, int i2, CharacterStyle characterStyle) {
        this.aqm = i;
        this.Ls = i2;
        this.AjW = characterStyle;
    }

    /* Access modifiers changed, original: final */
    public final void fz(List<d> list) {
        if (this.AjV == null) {
            this.AjV = new LinkedList();
            for (d dVar : list) {
                if (dVar.aqm <= this.aqm && this.Ls < dVar.Ls) {
                    this.AjV.add(dVar.hR(this.aqm, this.Ls));
                    return;
                } else if (dVar.aqm <= this.aqm && this.aqm < dVar.Ls && dVar.Ls <= this.Ls) {
                    this.AjV.add(dVar.hR(this.aqm, dVar.Ls));
                } else if (this.aqm < dVar.aqm && this.Ls < dVar.Ls && this.Ls >= dVar.aqm) {
                    this.AjV.add(dVar.hR(dVar.aqm, this.Ls));
                    return;
                } else if (this.aqm < dVar.aqm && this.Ls >= dVar.Ls) {
                    this.AjV.add(dVar.hR(dVar.aqm, dVar.Ls));
                }
            }
        }
    }

    public final boolean ak(float f, float f2) {
        if (this.AjV == null) {
            return false;
        }
        Iterator it = this.AjV.iterator();
        while (it.hasNext()) {
            if (((RectF) it.next()).contains(f, f2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.aqm != this.aqm || bVar.Ls != this.Ls) {
            return false;
        }
        for (int i = 0; i < this.AjV.size(); i++) {
            if (!((RectF) this.AjV.get(i)).equals((RectF) bVar.AjV.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.AjV.size(); i2++) {
            i += ((RectF) this.AjV.get(i2)).hashCode();
        }
        return (this.aqm + this.Ls) + i;
    }

    public String toString() {
        return "CharacterBgStyle{mRectFList=" + this.AjV + ", mStart=" + this.aqm + ", mEnd=" + this.Ls + '}';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.aqm);
        objectOutputStream.writeInt(this.Ls);
        objectOutputStream.writeInt(this.AjV.size());
        Iterator it = this.AjV.iterator();
        while (it.hasNext()) {
            RectF rectF = (RectF) it.next();
            objectOutputStream.writeFloat(rectF.left);
            objectOutputStream.writeFloat(rectF.top);
            objectOutputStream.writeFloat(rectF.right);
            objectOutputStream.writeFloat(rectF.bottom);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.aqm = objectInputStream.readInt();
        this.Ls = objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        this.AjV = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.AjV.add(new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat()));
        }
    }
}
