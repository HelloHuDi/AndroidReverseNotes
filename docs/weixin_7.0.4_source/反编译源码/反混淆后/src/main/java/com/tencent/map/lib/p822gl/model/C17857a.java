package com.tencent.map.lib.p822gl.model;

import android.graphics.Bitmap;
import android.opengl.GLU;
import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.p822gl.C17851b;
import com.tencent.map.lib.p822gl.C17852c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16225ff;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41047ex;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41048fb;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46782ey;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.map.lib.gl.model.a */
public class C17857a extends C25732b implements C41047ex {
    public static final int ELEMENT_ANIMATOR_ALPHA = 1;
    public static final int ELEMENT_ANIMATOR_ROTATE = 4;
    public static final int ELEMENT_ANIMATOR_SCALE = 2;
    public static final int ELEMENT_ANIMATOR_TRANSLATE = 3;
    public static final int STATE_DISABLE = 2;
    public static final int STATE_FOCUS = 1;
    public static final int STATE_NORMAL = 0;
    protected float alpha = 1.0f;
    private C17858a mAdapter;
    private int mState;
    private C8893b mTextureListener;
    protected float rotate = 0.0f;
    protected float scaleX = 1.0f;
    protected float scaleY = 1.0f;
    protected float translateX = 0.0f;
    protected float translateY = 0.0f;

    /* renamed from: com.tencent.map.lib.gl.model.a$b */
    public interface C8893b {
        /* renamed from: a */
        void mo20267a(Bitmap bitmap);
    }

    /* renamed from: com.tencent.map.lib.gl.model.a$a */
    public interface C17858a {
        Bitmap getTextureBm(int i);

        String getTextureUID();

        boolean hasTexture();
    }

    public synchronized void setAdapter(C17858a c17858a) {
        this.mAdapter = c17858a;
    }

    public void setTextureListener(C8893b c8893b) {
        this.mTextureListener = c8893b;
    }

    public synchronized void draw(GL10 gl10, C17851b c17851b) {
        AppMethodBeat.m2504i(98136);
        if (this.mAdapter == null) {
            RuntimeException runtimeException = new RuntimeException("please setAdapter first");
            AppMethodBeat.m2505o(98136);
            throw runtimeException;
        }
        gl10.glColor4f(this.alpha, this.alpha, this.alpha, this.alpha);
        gl10.glScalef(this.scaleX, this.scaleY, 1.0f);
        gl10.glTranslatef(this.translateX, this.translateY, 0.0f);
        gl10.glRotatef(this.rotate, 0.0f, 0.0f, 1.0f);
        performDraw(gl10, c17851b);
        gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        AppMethodBeat.m2505o(98136);
    }

    public synchronized void rebuild(float[] fArr, short[] sArr, float[] fArr2) {
        AppMethodBeat.m2504i(98137);
        setVertices(fArr);
        setIndices(sArr);
        setTextureCoordinates(fArr2);
        AppMethodBeat.m2505o(98137);
    }

    private void performDraw(GL10 gl10, C17851b c17851b) {
        AppMethodBeat.m2504i(98138);
        gl10.glPushMatrix();
        if (prepareDraw(gl10)) {
            if (this.mAdapter.hasTexture()) {
                drawTexture(gl10, c17851b);
            } else {
                super.drawWithTexture(gl10, 0);
            }
        }
        gl10.glPopMatrix();
        AppMethodBeat.m2505o(98138);
    }

    public void drawWithOrthogo(GL10 gl10, C17851b c17851b, int i, int i2) {
        AppMethodBeat.m2504i(98139);
        gl10.glMatrixMode(5889);
        gl10.glPushMatrix();
        gl10.glLoadIdentity();
        GLU.gluOrtho2D(gl10, 0.0f, (float) i, 0.0f, (float) i2);
        draw(gl10, c17851b);
        gl10.glPopMatrix();
        gl10.glMatrixMode(5888);
        AppMethodBeat.m2505o(98139);
    }

    private String getIdByState() {
        AppMethodBeat.m2504i(98140);
        String str = this.mAdapter.getTextureUID() + "_" + this.mState;
        AppMethodBeat.m2505o(98140);
        return str;
    }

    private void drawTexture(GL10 gl10, C17851b c17851b) {
        AppMethodBeat.m2504i(98141);
        String idByState = getIdByState();
        int a = c17851b.mo33212a(idByState);
        if (a == 0) {
            Bitmap textureBm = this.mAdapter.getTextureBm(this.mState);
            Bitmap a2 = C17852c.m27945a(textureBm);
            a = C17852c.m27944a(gl10, a2);
            if (a2 != textureBm) {
                a2.recycle();
            }
            if (this.mTextureListener != null) {
                this.mTextureListener.mo20267a(textureBm);
            }
            c17851b.mo33214a(idByState, a);
        }
        if (a != 0) {
            super.drawWithTexture(gl10, a);
        }
        AppMethodBeat.m2505o(98141);
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

    public C46782ey animator(int i, Object obj, Object obj2) {
        AppMethodBeat.m2504i(98142);
        C46782ey a;
        switch (i) {
            case 1:
                a = C16225ff.m24751a(this, 1, ((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
                AppMethodBeat.m2505o(98142);
                return a;
            case 2:
                a = C16225ff.m24750a(this, 2, new C41048fb(), obj, obj2);
                AppMethodBeat.m2505o(98142);
                return a;
            case 3:
                a = C16225ff.m24750a(this, 3, new C41048fb(), obj, obj2);
                AppMethodBeat.m2505o(98142);
                return a;
            case 4:
                a = C16225ff.m24751a(this, 4, ((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
                AppMethodBeat.m2505o(98142);
                return a;
            default:
                AppMethodBeat.m2505o(98142);
                return null;
        }
    }

    public void setPropertyValue(int i, Object obj) {
        AppMethodBeat.m2504i(98143);
        DoublePoint doublePoint;
        switch (i) {
            case 1:
                this.alpha = ((Number) obj).floatValue();
                AppMethodBeat.m2505o(98143);
                return;
            case 2:
                doublePoint = (DoublePoint) obj;
                this.scaleX = (float) doublePoint.f2800x;
                this.scaleY = (float) doublePoint.f2801y;
                AppMethodBeat.m2505o(98143);
                return;
            case 3:
                doublePoint = (DoublePoint) obj;
                this.translateX = (float) doublePoint.f2800x;
                this.translateY = (float) doublePoint.f2801y;
                AppMethodBeat.m2505o(98143);
                return;
            case 4:
                this.rotate = ((Number) obj).floatValue();
                break;
        }
        AppMethodBeat.m2505o(98143);
    }
}
