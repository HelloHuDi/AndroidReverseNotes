package com.tencent.neattextview.textview.p658b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.C7378d;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.neattextview.textview.b.b */
public abstract class C5781b<T extends CharacterStyle> implements Serializable {
    protected LinkedList<RectF> AjV;
    public CharacterStyle AjW;
    /* renamed from: Ls */
    private int f1360Ls;
    private int aqm;

    /* renamed from: a */
    public abstract void mo11829a(Canvas canvas, TextPaint textPaint, List<C7378d> list);

    C5781b(int i, int i2, CharacterStyle characterStyle) {
        this.aqm = i;
        this.f1360Ls = i2;
        this.AjW = characterStyle;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fz */
    public final void mo11832fz(List<C7378d> list) {
        if (this.AjV == null) {
            this.AjV = new LinkedList();
            for (C7378d c7378d : list) {
                if (c7378d.aqm <= this.aqm && this.f1360Ls < c7378d.f2011Ls) {
                    this.AjV.add(c7378d.mo15915hR(this.aqm, this.f1360Ls));
                    return;
                } else if (c7378d.aqm <= this.aqm && this.aqm < c7378d.f2011Ls && c7378d.f2011Ls <= this.f1360Ls) {
                    this.AjV.add(c7378d.mo15915hR(this.aqm, c7378d.f2011Ls));
                } else if (this.aqm < c7378d.aqm && this.f1360Ls < c7378d.f2011Ls && this.f1360Ls >= c7378d.aqm) {
                    this.AjV.add(c7378d.mo15915hR(c7378d.aqm, this.f1360Ls));
                    return;
                } else if (this.aqm < c7378d.aqm && this.f1360Ls >= c7378d.f2011Ls) {
                    this.AjV.add(c7378d.mo15915hR(c7378d.aqm, c7378d.f2011Ls));
                }
            }
        }
    }

    /* renamed from: ak */
    public final boolean mo11830ak(float f, float f2) {
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
        if (obj == null || !(obj instanceof C5781b)) {
            return false;
        }
        C5781b c5781b = (C5781b) obj;
        if (c5781b.aqm != this.aqm || c5781b.f1360Ls != this.f1360Ls) {
            return false;
        }
        for (int i = 0; i < this.AjV.size(); i++) {
            if (!((RectF) this.AjV.get(i)).equals((RectF) c5781b.AjV.get(i))) {
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
        return (this.aqm + this.f1360Ls) + i;
    }

    public String toString() {
        return "CharacterBgStyle{mRectFList=" + this.AjV + ", mStart=" + this.aqm + ", mEnd=" + this.f1360Ls + '}';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.aqm);
        objectOutputStream.writeInt(this.f1360Ls);
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
        this.f1360Ls = objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        this.AjV = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.AjV.add(new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat()));
        }
    }
}
