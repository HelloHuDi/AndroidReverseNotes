package com.tencent.map.lib.gl.model;

import android.graphics.Bitmap;
import android.opengl.GLU;
import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.gl.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ex;
import com.tencent.tencentmap.mapsdk.maps.a.ey;
import com.tencent.tencentmap.mapsdk.maps.a.fb;
import com.tencent.tencentmap.mapsdk.maps.a.ff;
import javax.microedition.khronos.opengles.GL10;

public class a extends b implements ex {
    public static final int ELEMENT_ANIMATOR_ALPHA = 1;
    public static final int ELEMENT_ANIMATOR_ROTATE = 4;
    public static final int ELEMENT_ANIMATOR_SCALE = 2;
    public static final int ELEMENT_ANIMATOR_TRANSLATE = 3;
    public static final int STATE_DISABLE = 2;
    public static final int STATE_FOCUS = 1;
    public static final int STATE_NORMAL = 0;
    protected float alpha = 1.0f;
    private a mAdapter;
    private int mState;
    private b mTextureListener;
    protected float rotate = 0.0f;
    protected float scaleX = 1.0f;
    protected float scaleY = 1.0f;
    protected float translateX = 0.0f;
    protected float translateY = 0.0f;

    public interface b {
        void a(Bitmap bitmap);
    }

    public interface a {
        Bitmap getTextureBm(int i);

        String getTextureUID();

        boolean hasTexture();
    }

    public synchronized void setAdapter(a aVar) {
        this.mAdapter = aVar;
    }

    public void setTextureListener(b bVar) {
        this.mTextureListener = bVar;
    }

    public synchronized void draw(GL10 gl10, com.tencent.map.lib.gl.b bVar) {
        AppMethodBeat.i(98136);
        if (this.mAdapter == null) {
            RuntimeException runtimeException = new RuntimeException("please setAdapter first");
            AppMethodBeat.o(98136);
            throw runtimeException;
        }
        gl10.glColor4f(this.alpha, this.alpha, this.alpha, this.alpha);
        gl10.glScalef(this.scaleX, this.scaleY, 1.0f);
        gl10.glTranslatef(this.translateX, this.translateY, 0.0f);
        gl10.glRotatef(this.rotate, 0.0f, 0.0f, 1.0f);
        performDraw(gl10, bVar);
        gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        AppMethodBeat.o(98136);
    }

    public synchronized void rebuild(float[] fArr, short[] sArr, float[] fArr2) {
        AppMethodBeat.i(98137);
        setVertices(fArr);
        setIndices(sArr);
        setTextureCoordinates(fArr2);
        AppMethodBeat.o(98137);
    }

    private void performDraw(GL10 gl10, com.tencent.map.lib.gl.b bVar) {
        AppMethodBeat.i(98138);
        gl10.glPushMatrix();
        if (prepareDraw(gl10)) {
            if (this.mAdapter.hasTexture()) {
                drawTexture(gl10, bVar);
            } else {
                super.drawWithTexture(gl10, 0);
            }
        }
        gl10.glPopMatrix();
        AppMethodBeat.o(98138);
    }

    public void drawWithOrthogo(GL10 gl10, com.tencent.map.lib.gl.b bVar, int i, int i2) {
        AppMethodBeat.i(98139);
        gl10.glMatrixMode(5889);
        gl10.glPushMatrix();
        gl10.glLoadIdentity();
        GLU.gluOrtho2D(gl10, 0.0f, (float) i, 0.0f, (float) i2);
        draw(gl10, bVar);
        gl10.glPopMatrix();
        gl10.glMatrixMode(5888);
        AppMethodBeat.o(98139);
    }

    private String getIdByState() {
        AppMethodBeat.i(98140);
        String str = this.mAdapter.getTextureUID() + "_" + this.mState;
        AppMethodBeat.o(98140);
        return str;
    }

    private void drawTexture(GL10 gl10, com.tencent.map.lib.gl.b bVar) {
        AppMethodBeat.i(98141);
        String idByState = getIdByState();
        int a = bVar.a(idByState);
        if (a == 0) {
            Bitmap textureBm = this.mAdapter.getTextureBm(this.mState);
            Bitmap a2 = c.a(textureBm);
            a = c.a(gl10, a2);
            if (a2 != textureBm) {
                a2.recycle();
            }
            if (this.mTextureListener != null) {
                this.mTextureListener.a(textureBm);
            }
            bVar.a(idByState, a);
        }
        if (a != 0) {
            super.drawWithTexture(gl10, a);
        }
        AppMethodBeat.o(98141);
    }

    /* Access modifiers changed, original: protected */
    public boolean prepareDraw(GL10 gl10) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTap(float f, float f2) {
        return false;
    }

    public void setState(int i) {
        this.mState = i;
        this.alpha = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.translateX = 0.0f;
        this.translateY = 0.0f;
    }

    public int getState() {
        return this.mState;
    }

    public ey animator(int i, Object obj, Object obj2) {
        AppMethodBeat.i(98142);
        ey a;
        switch (i) {
            case 1:
                a = ff.a(this, 1, ((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
                AppMethodBeat.o(98142);
                return a;
            case 2:
                a = ff.a(this, 2, new fb(), obj, obj2);
                AppMethodBeat.o(98142);
                return a;
            case 3:
                a = ff.a(this, 3, new fb(), obj, obj2);
                AppMethodBeat.o(98142);
                return a;
            case 4:
                a = ff.a(this, 4, ((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
                AppMethodBeat.o(98142);
                return a;
            default:
                AppMethodBeat.o(98142);
                return null;
        }
    }

    public void setPropertyValue(int i, Object obj) {
        AppMethodBeat.i(98143);
        DoublePoint doublePoint;
        switch (i) {
            case 1:
                this.alpha = ((Number) obj).floatValue();
                AppMethodBeat.o(98143);
                return;
            case 2:
                doublePoint = (DoublePoint) obj;
                this.scaleX = (float) doublePoint.x;
                this.scaleY = (float) doublePoint.y;
                AppMethodBeat.o(98143);
                return;
            case 3:
                doublePoint = (DoublePoint) obj;
                this.translateX = (float) doublePoint.x;
                this.translateY = (float) doublePoint.y;
                AppMethodBeat.o(98143);
                return;
            case 4:
                this.rotate = ((Number) obj).floatValue();
                break;
        }
        AppMethodBeat.o(98143);
    }
}
