package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.a.a.e.b;
import android.support.constraint.a.a.e.c;
import android.support.constraint.a.a.f;
import android.support.constraint.a.a.g;
import android.support.constraint.a.a.i;
import android.support.constraint.a.a.m;
import android.support.constraint.b.a;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xwalk.core.XWalkEnvironment;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> db = new SparseArray();
    private ArrayList<ConstraintHelper> dc = new ArrayList(4);
    private final ArrayList<f> dd = new ArrayList(100);
    g de = new g();
    private int dg = 0;
    private int dh = 0;
    private int di = BaseClientBuilder.API_PRIORITY_OTHER;
    private int dj = BaseClientBuilder.API_PRIORITY_OTHER;
    private boolean dk = true;
    private int dl = 7;
    private a dm = null;
    private int dn = -1;
    /* renamed from: do */
    private HashMap<String, Integer> f23do = new HashMap();
    private int dp = -1;
    private int dq = -1;
    int dr = -1;
    int ds = -1;
    int dt = 0;
    int du = 0;
    private android.support.constraint.a.f dv;

    public static class LayoutParams extends MarginLayoutParams {
        public float dA = -1.0f;
        public int dB = -1;
        public int dC = -1;
        public int dD = -1;
        public int dE = -1;
        public int dF = -1;
        public int dG = -1;
        public int dH = -1;
        public int dI = -1;
        public int dJ = -1;
        public int dK = -1;
        public int dL = 0;
        public float dM = 0.0f;
        public int dN = -1;
        public int dO = -1;
        public int dP = -1;
        public int dQ = -1;
        public int dR = -1;
        public int dS = -1;
        public int dT = -1;
        public int dU = -1;
        public int dV = -1;
        public int dW = -1;
        public float dX = 0.5f;
        public float dY = 0.5f;
        public String dZ = null;
        public int dw = -1;
        public int dz = -1;
        int eA = -1;
        int eB = -1;
        int eC = -1;
        float eD = 0.5f;
        int eE;
        int eF;
        float eG;
        f eH = new f();
        public boolean eI = false;
        float ea = 0.0f;
        int eb = 1;
        public int ec = 0;
        public int ed = 0;
        public int ee = 0;
        public int ef = 0;
        public int eg = 0;
        public int eh = 0;
        public int ei = 0;
        public int ej = 0;
        public float ek = 1.0f;
        public float el = 1.0f;
        public int em = -1;
        public int eo = -1;
        public boolean ep = false;
        public boolean eq = false;
        boolean er = true;
        boolean es = true;
        boolean et = false;
        boolean eu = false;
        boolean ev = false;
        boolean ew = false;
        int ex = -1;
        int ey = -1;
        int ez = -1;
        public float horizontalWeight = -1.0f;
        public int orientation = -1;
        public float verticalWeight = -1.0f;

        static class a {
            public static final SparseIntArray eJ;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                eJ = sparseIntArray;
                sparseIntArray.append(34, 8);
                eJ.append(35, 9);
                eJ.append(37, 10);
                eJ.append(38, 11);
                eJ.append(43, 12);
                eJ.append(42, 13);
                eJ.append(16, 14);
                eJ.append(15, 15);
                eJ.append(13, 16);
                eJ.append(17, 2);
                eJ.append(19, 3);
                eJ.append(18, 4);
                eJ.append(51, 49);
                eJ.append(52, 50);
                eJ.append(23, 5);
                eJ.append(24, 6);
                eJ.append(25, 7);
                eJ.append(0, 1);
                eJ.append(39, 17);
                eJ.append(40, 18);
                eJ.append(22, 19);
                eJ.append(21, 20);
                eJ.append(55, 21);
                eJ.append(58, 22);
                eJ.append(56, 23);
                eJ.append(53, 24);
                eJ.append(57, 25);
                eJ.append(54, 26);
                eJ.append(30, 29);
                eJ.append(44, 30);
                eJ.append(20, 44);
                eJ.append(32, 45);
                eJ.append(46, 46);
                eJ.append(31, 47);
                eJ.append(45, 48);
                eJ.append(11, 27);
                eJ.append(10, 28);
                eJ.append(47, 31);
                eJ.append(26, 32);
                eJ.append(49, 33);
                eJ.append(48, 34);
                eJ.append(50, 35);
                eJ.append(28, 36);
                eJ.append(27, 37);
                eJ.append(29, 38);
                eJ.append(33, 39);
                eJ.append(41, 40);
                eJ.append(36, 41);
                eJ.append(14, 42);
                eJ.append(12, 43);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.constraint.b.a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (a.eJ.get(index)) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        this.dK = obtainStyledAttributes.getResourceId(index, this.dK);
                        if (this.dK != -1) {
                            break;
                        }
                        this.dK = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 3:
                        this.dL = obtainStyledAttributes.getDimensionPixelSize(index, this.dL);
                        break;
                    case 4:
                        this.dM = obtainStyledAttributes.getFloat(index, this.dM) % 360.0f;
                        if (this.dM >= 0.0f) {
                            break;
                        }
                        this.dM = (360.0f - this.dM) % 360.0f;
                        break;
                    case 5:
                        this.dw = obtainStyledAttributes.getDimensionPixelOffset(index, this.dw);
                        break;
                    case 6:
                        this.dz = obtainStyledAttributes.getDimensionPixelOffset(index, this.dz);
                        break;
                    case 7:
                        this.dA = obtainStyledAttributes.getFloat(index, this.dA);
                        break;
                    case 8:
                        this.dB = obtainStyledAttributes.getResourceId(index, this.dB);
                        if (this.dB != -1) {
                            break;
                        }
                        this.dB = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 9:
                        this.dC = obtainStyledAttributes.getResourceId(index, this.dC);
                        if (this.dC != -1) {
                            break;
                        }
                        this.dC = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 10:
                        this.dD = obtainStyledAttributes.getResourceId(index, this.dD);
                        if (this.dD != -1) {
                            break;
                        }
                        this.dD = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 11:
                        this.dE = obtainStyledAttributes.getResourceId(index, this.dE);
                        if (this.dE != -1) {
                            break;
                        }
                        this.dE = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 12:
                        this.dF = obtainStyledAttributes.getResourceId(index, this.dF);
                        if (this.dF != -1) {
                            break;
                        }
                        this.dF = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 13:
                        this.dG = obtainStyledAttributes.getResourceId(index, this.dG);
                        if (this.dG != -1) {
                            break;
                        }
                        this.dG = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 14:
                        this.dH = obtainStyledAttributes.getResourceId(index, this.dH);
                        if (this.dH != -1) {
                            break;
                        }
                        this.dH = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 15:
                        this.dI = obtainStyledAttributes.getResourceId(index, this.dI);
                        if (this.dI != -1) {
                            break;
                        }
                        this.dI = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 16:
                        this.dJ = obtainStyledAttributes.getResourceId(index, this.dJ);
                        if (this.dJ != -1) {
                            break;
                        }
                        this.dJ = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 17:
                        this.dN = obtainStyledAttributes.getResourceId(index, this.dN);
                        if (this.dN != -1) {
                            break;
                        }
                        this.dN = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 18:
                        this.dO = obtainStyledAttributes.getResourceId(index, this.dO);
                        if (this.dO != -1) {
                            break;
                        }
                        this.dO = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 19:
                        this.dP = obtainStyledAttributes.getResourceId(index, this.dP);
                        if (this.dP != -1) {
                            break;
                        }
                        this.dP = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 20:
                        this.dQ = obtainStyledAttributes.getResourceId(index, this.dQ);
                        if (this.dQ != -1) {
                            break;
                        }
                        this.dQ = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 21:
                        this.dR = obtainStyledAttributes.getDimensionPixelSize(index, this.dR);
                        break;
                    case 22:
                        this.dS = obtainStyledAttributes.getDimensionPixelSize(index, this.dS);
                        break;
                    case 23:
                        this.dT = obtainStyledAttributes.getDimensionPixelSize(index, this.dT);
                        break;
                    case 24:
                        this.dU = obtainStyledAttributes.getDimensionPixelSize(index, this.dU);
                        break;
                    case 25:
                        this.dV = obtainStyledAttributes.getDimensionPixelSize(index, this.dV);
                        break;
                    case 26:
                        this.dW = obtainStyledAttributes.getDimensionPixelSize(index, this.dW);
                        break;
                    case 27:
                        this.ep = obtainStyledAttributes.getBoolean(index, this.ep);
                        break;
                    case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        this.eq = obtainStyledAttributes.getBoolean(index, this.eq);
                        break;
                    case 29:
                        this.dX = obtainStyledAttributes.getFloat(index, this.dX);
                        break;
                    case 30:
                        this.dY = obtainStyledAttributes.getFloat(index, this.dY);
                        break;
                    case 31:
                        this.ee = obtainStyledAttributes.getInt(index, 0);
                        if (this.ee == 1) {
                        }
                        break;
                    case 32:
                        this.ef = obtainStyledAttributes.getInt(index, 0);
                        if (this.ef == 1) {
                        }
                        break;
                    case 33:
                        try {
                            this.eg = obtainStyledAttributes.getDimensionPixelSize(index, this.eg);
                            break;
                        } catch (Exception e) {
                            if (obtainStyledAttributes.getInt(index, this.eg) != -2) {
                                break;
                            }
                            this.eg = -2;
                            break;
                        }
                    case 34:
                        try {
                            this.ei = obtainStyledAttributes.getDimensionPixelSize(index, this.ei);
                            break;
                        } catch (Exception e2) {
                            if (obtainStyledAttributes.getInt(index, this.ei) != -2) {
                                break;
                            }
                            this.ei = -2;
                            break;
                        }
                    case 35:
                        this.ek = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.ek));
                        break;
                    case 36:
                        try {
                            this.eh = obtainStyledAttributes.getDimensionPixelSize(index, this.eh);
                            break;
                        } catch (Exception e3) {
                            if (obtainStyledAttributes.getInt(index, this.eh) != -2) {
                                break;
                            }
                            this.eh = -2;
                            break;
                        }
                    case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                        try {
                            this.ej = obtainStyledAttributes.getDimensionPixelSize(index, this.ej);
                            break;
                        } catch (Exception e4) {
                            if (obtainStyledAttributes.getInt(index, this.ej) != -2) {
                                break;
                            }
                            this.ej = -2;
                            break;
                        }
                    case 38:
                        this.el = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.el));
                        break;
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        this.dZ = obtainStyledAttributes.getString(index);
                        this.ea = Float.NaN;
                        this.eb = -1;
                        if (this.dZ == null) {
                            break;
                        }
                        int length = this.dZ.length();
                        index = this.dZ.indexOf(44);
                        if (index <= 0 || index >= length - 1) {
                            index = 0;
                        } else {
                            String substring = this.dZ.substring(0, index);
                            if (substring.equalsIgnoreCase(QLog.TAG_REPORTLEVEL_COLORUSER)) {
                                this.eb = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.eb = 1;
                            }
                            index++;
                        }
                        int indexOf = this.dZ.indexOf(58);
                        String substring2;
                        if (indexOf >= 0 && indexOf < length - 1) {
                            substring2 = this.dZ.substring(index, indexOf);
                            String substring3 = this.dZ.substring(indexOf + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.eb != 1) {
                                            this.ea = Math.abs(parseFloat / parseFloat2);
                                            break;
                                        } else {
                                            this.ea = Math.abs(parseFloat2 / parseFloat);
                                            break;
                                        }
                                    }
                                } catch (NumberFormatException e5) {
                                    break;
                                }
                            }
                        }
                        substring2 = this.dZ.substring(index);
                        if (substring2.length() <= 0) {
                            break;
                        }
                        try {
                            this.ea = Float.parseFloat(substring2);
                            break;
                        } catch (NumberFormatException e6) {
                            break;
                        }
                        break;
                    case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 46:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        this.ec = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.ed = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        this.em = obtainStyledAttributes.getDimensionPixelOffset(index, this.em);
                        break;
                    case 50:
                        this.eo = obtainStyledAttributes.getDimensionPixelOffset(index, this.eo);
                        break;
                    default:
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public final void validate() {
            this.eu = false;
            this.er = true;
            this.es = true;
            if (this.width == -2 && this.ep) {
                this.er = false;
                this.ee = 1;
            }
            if (this.height == -2 && this.eq) {
                this.es = false;
                this.ef = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.er = false;
                if (this.width == 0 && this.ee == 1) {
                    this.width = -2;
                    this.ep = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.es = false;
                if (this.height == 0 && this.ef == 1) {
                    this.height = -2;
                    this.eq = true;
                }
            }
            if (this.dA != -1.0f || this.dw != -1 || this.dz != -1) {
                this.eu = true;
                this.er = true;
                this.es = true;
                if (!(this.eH instanceof i)) {
                    this.eH = new i();
                }
                ((i) this.eH).setOrientation(this.orientation);
            }
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            Object obj = null;
            int i2 = this.leftMargin;
            int i3 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.ez = -1;
            this.eA = -1;
            this.ex = -1;
            this.ey = -1;
            this.eB = -1;
            this.eC = -1;
            this.eB = this.dR;
            this.eC = this.dT;
            this.eD = this.dX;
            this.eE = this.dw;
            this.eF = this.dz;
            this.eG = this.dA;
            if ((1 == getLayoutDirection() ? 1 : null) != null) {
                if (this.dN != -1) {
                    this.ez = this.dN;
                    obj = 1;
                } else if (this.dO != -1) {
                    this.eA = this.dO;
                    int obj2 = 1;
                }
                if (this.dP != -1) {
                    this.ey = this.dP;
                    obj2 = 1;
                }
                if (this.dQ != -1) {
                    this.ex = this.dQ;
                    obj2 = 1;
                }
                if (this.dV != -1) {
                    this.eC = this.dV;
                }
                if (this.dW != -1) {
                    this.eB = this.dW;
                }
                if (obj2 != null) {
                    this.eD = 1.0f - this.dX;
                }
                if (this.eu && this.orientation == 1) {
                    if (this.dA != -1.0f) {
                        this.eG = 1.0f - this.dA;
                        this.eE = -1;
                        this.eF = -1;
                    } else if (this.dw != -1) {
                        this.eF = this.dw;
                        this.eE = -1;
                        this.eG = -1.0f;
                    } else if (this.dz != -1) {
                        this.eE = this.dz;
                        this.eF = -1;
                        this.eG = -1.0f;
                    }
                }
            } else {
                if (this.dN != -1) {
                    this.ey = this.dN;
                }
                if (this.dO != -1) {
                    this.ex = this.dO;
                }
                if (this.dP != -1) {
                    this.ez = this.dP;
                }
                if (this.dQ != -1) {
                    this.eA = this.dQ;
                }
                if (this.dV != -1) {
                    this.eB = this.dV;
                }
                if (this.dW != -1) {
                    this.eC = this.dW;
                }
            }
            if (this.dP == -1 && this.dQ == -1 && this.dO == -1 && this.dN == -1) {
                if (this.dD != -1) {
                    this.ez = this.dD;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else if (this.dE != -1) {
                    this.eA = this.dE;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                }
                if (this.dB != -1) {
                    this.ex = this.dB;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                } else if (this.dC != -1) {
                    this.ey = this.dC;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                }
            }
        }
    }

    private void c(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f23do == null) {
                this.f23do = new HashMap();
            }
            obj = (String) obj;
            int indexOf = obj.indexOf("/");
            if (indexOf != -1) {
                obj = obj.substring(indexOf + 1);
            }
            this.f23do.put(obj, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public final Object f(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (this.f23do != null && this.f23do.containsKey(str)) {
                return this.f23do.get(str);
            }
        }
        return null;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
    }

    public void setId(int i) {
        this.db.remove(getId());
        super.setId(i);
        this.db.put(getId(), this);
    }

    private void b(AttributeSet attributeSet) {
        this.de.iX = this;
        this.db.put(getId(), this);
        this.dm = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 3) {
                    this.dg = obtainStyledAttributes.getDimensionPixelOffset(index, this.dg);
                } else if (index == 4) {
                    this.dh = obtainStyledAttributes.getDimensionPixelOffset(index, this.dh);
                } else if (index == 1) {
                    this.di = obtainStyledAttributes.getDimensionPixelOffset(index, this.di);
                } else if (index == 2) {
                    this.dj = obtainStyledAttributes.getDimensionPixelOffset(index, this.dj);
                } else if (index == 59) {
                    this.dl = obtainStyledAttributes.getInt(index, this.dl);
                } else if (index == 8) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.dm = new a();
                        a aVar = this.dm;
                        Context context = getContext();
                        XmlResourceParser xml = context.getResources().getXml(resourceId);
                        try {
                            for (index = xml.getEventType(); index != 1; index = xml.next()) {
                                switch (index) {
                                    case 0:
                                        xml.getName();
                                        break;
                                    case 2:
                                        String name = xml.getName();
                                        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                        a aVar2 = new a();
                                        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(asAttributeSet, a.ConstraintSet);
                                        a.a(aVar2, obtainStyledAttributes2);
                                        obtainStyledAttributes2.recycle();
                                        if (name.equalsIgnoreCase("Guideline")) {
                                            aVar2.eN = true;
                                        }
                                        aVar.eL.put(Integer.valueOf(aVar2.eO), aVar2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (IOException | XmlPullParserException e) {
                        }
                    } catch (NotFoundException e2) {
                        this.dm = null;
                    }
                    this.dn = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.de.dl = this.dl;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        f b = b(view);
        if ((view instanceof Guideline) && !(b instanceof i)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.eH = new i();
            layoutParams.eu = true;
            ((i) layoutParams.eH).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.ap();
            ((LayoutParams) view.getLayoutParams()).ev = true;
            if (!this.dc.contains(constraintHelper)) {
                this.dc.add(constraintHelper);
            }
        }
        this.db.put(view.getId(), view);
        this.dk = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.db.remove(view.getId());
        f b = b(view);
        this.de.f(b);
        this.dc.remove(view);
        this.dd.remove(b);
        this.dk = true;
    }

    public void setMinWidth(int i) {
        if (i != this.dg) {
            this.dg = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.dh) {
            this.dh = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.dg;
    }

    public int getMinHeight() {
        return this.dh;
    }

    public void setMaxWidth(int i) {
        if (i != this.di) {
            this.di = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.dj) {
            this.dj = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.di;
    }

    public int getMaxHeight() {
        return this.dj;
    }

    private final f p(int i) {
        if (i == 0) {
            return this.de;
        }
        View view = (View) this.db.get(i);
        if (view == null) {
            view = findViewById(i);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.de;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).eH;
    }

    public final f b(View view) {
        if (view == this) {
            return this.de;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).eH;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x08f8  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x08f8  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x07bc  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x08bd  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x07c9  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x07cc  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x07d5  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x08d1  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x07de  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x08f8  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0798  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x07a8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x07bc  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x07c9  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x08bd  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x07cc  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x07d5  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x07de  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x08d1  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x08f8  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0912  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0882  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0888  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x088e  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0897  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x08ad A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        int childCount;
        Object obj;
        int i3;
        View childAt;
        int i4;
        f b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        View view;
        LayoutParams layoutParams;
        Object obj2;
        LayoutParams layoutParams2;
        Object obj3;
        int i10;
        Object obj4;
        Object obj5;
        Object obj6;
        System.currentTimeMillis();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.de.setX(paddingLeft);
        this.de.setY(paddingTop);
        this.de.is[0] = this.di;
        this.de.is[1] = this.dj;
        if (VERSION.SDK_INT >= 17) {
            boolean z;
            g gVar = this.de;
            if (getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            gVar.hq = z;
        }
        int mode3 = MeasureSpec.getMode(i);
        int size3 = MeasureSpec.getSize(i);
        int mode4 = MeasureSpec.getMode(i2);
        int size4 = MeasureSpec.getSize(i2);
        int paddingTop2 = getPaddingTop() + getPaddingBottom();
        int paddingLeft2 = getPaddingLeft() + getPaddingRight();
        f.a aVar = f.a.FIXED;
        f.a aVar2 = f.a.FIXED;
        getLayoutParams();
        switch (mode3) {
            case j.INVALID_ID /*-2147483648*/:
                aVar = f.a.WRAP_CONTENT;
                break;
            case 0:
                aVar = f.a.WRAP_CONTENT;
                size3 = 0;
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                size3 = Math.min(this.di, size3) - paddingLeft2;
                break;
            default:
                size3 = 0;
                break;
        }
        switch (mode4) {
            case j.INVALID_ID /*-2147483648*/:
                aVar2 = f.a.WRAP_CONTENT;
                break;
            case 0:
                aVar2 = f.a.WRAP_CONTENT;
                size4 = 0;
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                size4 = Math.min(this.dj, size4) - paddingTop2;
                break;
            default:
                size4 = 0;
                break;
        }
        this.de.setMinWidth(0);
        this.de.setMinHeight(0);
        this.de.a(aVar);
        this.de.setWidth(size3);
        this.de.b(aVar2);
        this.de.setHeight(size4);
        this.de.setMinWidth((this.dg - getPaddingLeft()) - getPaddingRight());
        this.de.setMinHeight((this.dh - getPaddingTop()) - getPaddingBottom());
        int width = this.de.getWidth();
        int height = this.de.getHeight();
        Object obj7;
        if (this.dk) {
            this.dk = false;
            childCount = getChildCount();
            obj = null;
            i3 = 0;
            while (i3 < childCount) {
                if (getChildAt(i3).isLayoutRequested()) {
                    obj = 1;
                    if (obj != null) {
                        View childAt2;
                        String resourceName;
                        this.dd.clear();
                        boolean isInEditMode = isInEditMode();
                        int childCount2 = getChildCount();
                        if (isInEditMode) {
                            for (size4 = 0; size4 < childCount2; size4++) {
                                childAt2 = getChildAt(size4);
                                try {
                                    resourceName = getResources().getResourceName(childAt2.getId());
                                    c(resourceName, Integer.valueOf(childAt2.getId()));
                                    size3 = resourceName.indexOf(47);
                                    if (size3 != -1) {
                                        resourceName = resourceName.substring(size3 + 1);
                                    }
                                    p(childAt2.getId()).ja = resourceName;
                                } catch (NotFoundException e) {
                                }
                            }
                        }
                        for (size4 = 0; size4 < childCount2; size4++) {
                            f b2 = b(getChildAt(size4));
                            if (b2 != null) {
                                b2.reset();
                            }
                        }
                        if (this.dn != -1) {
                            size4 = 0;
                            while (true) {
                                i3 = size4;
                                if (i3 < childCount2) {
                                    childAt = getChildAt(i3);
                                    if (childAt.getId() == this.dn && (childAt instanceof Constraints)) {
                                        this.dm = ((Constraints) childAt).getConstraintSet();
                                    }
                                    size4 = i3 + 1;
                                }
                            }
                        }
                        if (this.dm != null) {
                            this.dm.b(this);
                        }
                        this.de.bh();
                        childCount = this.dc.size();
                        if (childCount > 0) {
                            for (i3 = 0; i3 < childCount; i3++) {
                                ((ConstraintHelper) this.dc.get(i3)).a(this);
                            }
                        }
                        size4 = 0;
                        while (true) {
                            childCount = size4;
                            if (childCount < childCount2) {
                                childAt = getChildAt(childCount);
                                if (childAt instanceof Placeholder) {
                                    Placeholder placeholder = (Placeholder) childAt;
                                    if (placeholder.fq == -1 && !placeholder.isInEditMode()) {
                                        placeholder.setVisibility(placeholder.ft);
                                    }
                                    placeholder.fs = findViewById(placeholder.fq);
                                    if (placeholder.fs != null) {
                                        ((LayoutParams) placeholder.fs.getLayoutParams()).ew = true;
                                        placeholder.fs.setVisibility(0);
                                        placeholder.setVisibility(0);
                                    }
                                }
                                size4 = childCount + 1;
                            } else {
                                size4 = 0;
                                while (true) {
                                    i4 = size4;
                                    if (i4 < childCount2) {
                                        childAt2 = getChildAt(i4);
                                        b = b(childAt2);
                                        if (b != null) {
                                            LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                                            layoutParams3.validate();
                                            if (layoutParams3.eI) {
                                                layoutParams3.eI = false;
                                            } else if (isInEditMode) {
                                                try {
                                                    resourceName = getResources().getResourceName(childAt2.getId());
                                                    c(resourceName, Integer.valueOf(childAt2.getId()));
                                                    p(childAt2.getId()).ja = resourceName.substring(resourceName.indexOf("id/") + 3);
                                                } catch (NotFoundException e2) {
                                                }
                                            }
                                            b.iZ = childAt2.getVisibility();
                                            if (layoutParams3.ew) {
                                                b.iZ = 8;
                                            }
                                            b.iX = childAt2;
                                            this.de.e(b);
                                            if (!(layoutParams3.es && layoutParams3.er)) {
                                                this.dd.add(b);
                                            }
                                            float f;
                                            if (layoutParams3.eu) {
                                                i iVar = (i) b;
                                                size3 = layoutParams3.eE;
                                                childCount = layoutParams3.eF;
                                                f = layoutParams3.eG;
                                                if (VERSION.SDK_INT < 17) {
                                                    size3 = layoutParams3.dw;
                                                    childCount = layoutParams3.dz;
                                                    f = layoutParams3.dA;
                                                }
                                                if (f != -1.0f) {
                                                    iVar.g(f);
                                                } else if (size3 != -1) {
                                                    iVar.B(size3);
                                                } else if (childCount != -1) {
                                                    iVar.C(childCount);
                                                }
                                            } else if (layoutParams3.dB != -1 || layoutParams3.dC != -1 || layoutParams3.dD != -1 || layoutParams3.dE != -1 || layoutParams3.dO != -1 || layoutParams3.dN != -1 || layoutParams3.dP != -1 || layoutParams3.dQ != -1 || layoutParams3.dF != -1 || layoutParams3.dG != -1 || layoutParams3.dH != -1 || layoutParams3.dI != -1 || layoutParams3.dJ != -1 || layoutParams3.em != -1 || layoutParams3.eo != -1 || layoutParams3.dK != -1 || layoutParams3.width == -1 || layoutParams3.height == -1) {
                                                float f2;
                                                float f3;
                                                i5 = layoutParams3.ex;
                                                i6 = layoutParams3.ey;
                                                i7 = layoutParams3.ez;
                                                size3 = layoutParams3.eA;
                                                i8 = layoutParams3.eB;
                                                childCount = layoutParams3.eC;
                                                f = layoutParams3.eD;
                                                if (VERSION.SDK_INT < 17) {
                                                    i5 = layoutParams3.dB;
                                                    i6 = layoutParams3.dC;
                                                    i7 = layoutParams3.dD;
                                                    size3 = layoutParams3.dE;
                                                    i8 = layoutParams3.dR;
                                                    childCount = layoutParams3.dT;
                                                    f = layoutParams3.dX;
                                                    if (i5 == -1 && i6 == -1) {
                                                        if (layoutParams3.dO != -1) {
                                                            i5 = layoutParams3.dO;
                                                        } else if (layoutParams3.dN != -1) {
                                                            i6 = layoutParams3.dN;
                                                        }
                                                    }
                                                    if (i7 == -1 && size3 == -1) {
                                                        if (layoutParams3.dP != -1) {
                                                            f2 = f;
                                                            mode3 = childCount;
                                                            mode4 = size3;
                                                            i9 = layoutParams3.dP;
                                                        } else if (layoutParams3.dQ != -1) {
                                                            f2 = f;
                                                            mode3 = childCount;
                                                            mode4 = layoutParams3.dQ;
                                                            i9 = i7;
                                                        }
                                                        f p;
                                                        if (layoutParams3.dK == -1) {
                                                            p = p(layoutParams3.dK);
                                                            if (p != null) {
                                                                float f4 = layoutParams3.dM;
                                                                b.a(c.CENTER, p, c.CENTER, layoutParams3.dL, 0);
                                                                b.it = f4;
                                                            }
                                                        } else {
                                                            if (i5 != -1) {
                                                                p = p(i5);
                                                                if (p != null) {
                                                                    b.a(c.LEFT, p, c.LEFT, layoutParams3.leftMargin, i8);
                                                                }
                                                            } else if (i6 != -1) {
                                                                p = p(i6);
                                                                if (p != null) {
                                                                    b.a(c.LEFT, p, c.RIGHT, layoutParams3.leftMargin, i8);
                                                                }
                                                            }
                                                            if (i9 != -1) {
                                                                p = p(i9);
                                                                if (p != null) {
                                                                    b.a(c.RIGHT, p, c.LEFT, layoutParams3.rightMargin, mode3);
                                                                }
                                                            } else if (mode4 != -1) {
                                                                p = p(mode4);
                                                                if (p != null) {
                                                                    b.a(c.RIGHT, p, c.RIGHT, layoutParams3.rightMargin, mode3);
                                                                }
                                                            }
                                                            if (layoutParams3.dF != -1) {
                                                                p = p(layoutParams3.dF);
                                                                if (p != null) {
                                                                    b.a(c.TOP, p, c.TOP, layoutParams3.topMargin, layoutParams3.dS);
                                                                }
                                                            } else if (layoutParams3.dG != -1) {
                                                                p = p(layoutParams3.dG);
                                                                if (p != null) {
                                                                    b.a(c.TOP, p, c.BOTTOM, layoutParams3.topMargin, layoutParams3.dS);
                                                                }
                                                            }
                                                            if (layoutParams3.dH != -1) {
                                                                p = p(layoutParams3.dH);
                                                                if (p != null) {
                                                                    b.a(c.BOTTOM, p, c.TOP, layoutParams3.bottomMargin, layoutParams3.dU);
                                                                }
                                                            } else if (layoutParams3.dI != -1) {
                                                                p = p(layoutParams3.dI);
                                                                if (p != null) {
                                                                    b.a(c.BOTTOM, p, c.BOTTOM, layoutParams3.bottomMargin, layoutParams3.dU);
                                                                }
                                                            }
                                                            if (layoutParams3.dJ != -1) {
                                                                view = (View) this.db.get(layoutParams3.dJ);
                                                                p = p(layoutParams3.dJ);
                                                                if (!(p == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                                                    layoutParams = (LayoutParams) view.getLayoutParams();
                                                                    layoutParams3.et = true;
                                                                    layoutParams.et = true;
                                                                    b.a(c.BASELINE).a(p.a(c.BASELINE), 0, -1, b.STRONG, 0, true);
                                                                    b.a(c.TOP).reset();
                                                                    b.a(c.BOTTOM).reset();
                                                                }
                                                            }
                                                            if (f2 >= 0.0f && f2 != 0.5f) {
                                                                b.iV = f2;
                                                            }
                                                            if (layoutParams3.dY >= 0.0f && layoutParams3.dY != 0.5f) {
                                                                b.iW = layoutParams3.dY;
                                                            }
                                                        }
                                                        if (isInEditMode && !(layoutParams3.em == -1 && layoutParams3.eo == -1)) {
                                                            b.f(layoutParams3.em, layoutParams3.eo);
                                                        }
                                                        if (!layoutParams3.er) {
                                                            b.a(f.a.FIXED);
                                                            b.setWidth(layoutParams3.width);
                                                        } else if (layoutParams3.width == -1) {
                                                            b.a(f.a.MATCH_PARENT);
                                                            b.a(c.LEFT).hz = layoutParams3.leftMargin;
                                                            b.a(c.RIGHT).hz = layoutParams3.rightMargin;
                                                        } else {
                                                            b.a(f.a.MATCH_CONSTRAINT);
                                                            b.setWidth(0);
                                                        }
                                                        if (!layoutParams3.es) {
                                                            b.b(f.a.FIXED);
                                                            b.setHeight(layoutParams3.height);
                                                        } else if (layoutParams3.height == -1) {
                                                            b.b(f.a.MATCH_PARENT);
                                                            b.a(c.TOP).hz = layoutParams3.topMargin;
                                                            b.a(c.BOTTOM).hz = layoutParams3.bottomMargin;
                                                        } else {
                                                            b.b(f.a.MATCH_CONSTRAINT);
                                                            b.setHeight(0);
                                                        }
                                                        if (layoutParams3.dZ != null) {
                                                            b.B(layoutParams3.dZ);
                                                        }
                                                        b.jk[0] = layoutParams3.horizontalWeight;
                                                        b.jk[1] = layoutParams3.verticalWeight;
                                                        b.jg = layoutParams3.ec;
                                                        b.jh = layoutParams3.ed;
                                                        i3 = layoutParams3.ee;
                                                        childCount = layoutParams3.eg;
                                                        size3 = layoutParams3.ei;
                                                        f3 = layoutParams3.ek;
                                                        b.ib = i3;
                                                        b.f3if = childCount;
                                                        b.ig = size3;
                                                        b.ih = f3;
                                                        if (f3 < 1.0f && b.ib == 0) {
                                                            b.ib = 2;
                                                        }
                                                        i3 = layoutParams3.ef;
                                                        childCount = layoutParams3.eh;
                                                        size3 = layoutParams3.ej;
                                                        f3 = layoutParams3.el;
                                                        b.ic = i3;
                                                        b.ii = childCount;
                                                        b.ij = size3;
                                                        b.ik = f3;
                                                        if (f3 < 1.0f && b.ic == 0) {
                                                            b.ic = 2;
                                                        }
                                                    }
                                                }
                                                f2 = f;
                                                mode3 = childCount;
                                                mode4 = size3;
                                                i9 = i7;
                                                if (layoutParams3.dK == -1) {
                                                }
                                                b.f(layoutParams3.em, layoutParams3.eo);
                                                if (!layoutParams3.er) {
                                                }
                                                if (!layoutParams3.es) {
                                                }
                                                if (layoutParams3.dZ != null) {
                                                }
                                                b.jk[0] = layoutParams3.horizontalWeight;
                                                b.jk[1] = layoutParams3.verticalWeight;
                                                b.jg = layoutParams3.ec;
                                                b.jh = layoutParams3.ed;
                                                i3 = layoutParams3.ee;
                                                childCount = layoutParams3.eg;
                                                size3 = layoutParams3.ei;
                                                f3 = layoutParams3.ek;
                                                b.ib = i3;
                                                b.f3if = childCount;
                                                b.ig = size3;
                                                b.ih = f3;
                                                b.ib = 2;
                                                i3 = layoutParams3.ef;
                                                childCount = layoutParams3.eh;
                                                size3 = layoutParams3.ej;
                                                f3 = layoutParams3.el;
                                                b.ic = i3;
                                                b.ii = childCount;
                                                b.ij = size3;
                                                b.ik = f3;
                                                b.ic = 2;
                                            }
                                        }
                                        size4 = i4 + 1;
                                    }
                                }
                            }
                        }
                    }
                    obj7 = 1;
                } else {
                    i3++;
                }
            }
            if (obj != null) {
            }
            obj7 = 1;
        } else {
            obj7 = null;
        }
        if ((this.dl & 8) == 8) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        Object obj8;
        android.support.constraint.a.f fVar;
        boolean z2;
        if (obj2 != null) {
            g gVar2 = this.de;
            gVar2.bb();
            gVar2.u(gVar2.dl);
            this.de.j(width, height);
            int paddingTop3 = getPaddingTop() + getPaddingBottom();
            int paddingLeft3 = getPaddingLeft() + getPaddingRight();
            int childCount3 = getChildCount();
            size4 = 0;
            while (true) {
                i8 = size4;
                if (i8 < childCount3) {
                    View childAt3 = getChildAt(i8);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                        f fVar2 = layoutParams2.eH;
                        if (!(layoutParams2.eu || layoutParams2.ev)) {
                            fVar2.iZ = childAt3.getVisibility();
                            i7 = layoutParams2.width;
                            paddingTop2 = layoutParams2.height;
                            if (i7 == 0 || paddingTop2 == 0) {
                                fVar2.aM().invalidate();
                                fVar2.aN().invalidate();
                            } else {
                                boolean z3;
                                obj8 = null;
                                obj3 = null;
                                if (i7 == -2) {
                                    obj8 = 1;
                                }
                                paddingLeft2 = getChildMeasureSpec(i, paddingLeft3, i7);
                                if (paddingTop2 == -2) {
                                    obj3 = 1;
                                }
                                childAt3.measure(paddingLeft2, getChildMeasureSpec(i2, paddingTop3, paddingTop2));
                                if (this.dv != null) {
                                    android.support.constraint.a.f fVar3 = this.dv;
                                    fVar3.gd++;
                                }
                                if (i7 == -2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                fVar2.il = z3;
                                if (paddingTop2 == -2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                fVar2.im = z3;
                                i7 = childAt3.getMeasuredWidth();
                                paddingTop2 = childAt3.getMeasuredHeight();
                                fVar2.setWidth(i7);
                                fVar2.setHeight(paddingTop2);
                                if (obj8 != null) {
                                    fVar2.iS = i7;
                                }
                                if (obj3 != null) {
                                    fVar2.iT = paddingTop2;
                                }
                                if (layoutParams2.et) {
                                    i3 = childAt3.getBaseline();
                                    if (i3 != -1) {
                                        fVar2.iR = i3;
                                    }
                                }
                                if (layoutParams2.er && layoutParams2.es) {
                                    fVar2.aM().E(i7);
                                    fVar2.aN().E(paddingTop2);
                                }
                            }
                        }
                    }
                    size4 = i8 + 1;
                } else {
                    this.de.ba();
                    size4 = 0;
                    while (true) {
                        i10 = size4;
                        if (i10 < childCount3) {
                            View childAt4 = getChildAt(i10);
                            if (childAt4.getVisibility() != 8) {
                                layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                                f fVar4 = layoutParams2.eH;
                                if (!(layoutParams2.eu || layoutParams2.ev)) {
                                    fVar4.iZ = childAt4.getVisibility();
                                    i8 = layoutParams2.width;
                                    mode4 = layoutParams2.height;
                                    if (i8 == 0 || mode4 == 0) {
                                        m mVar;
                                        m mVar2;
                                        Object obj9;
                                        Object obj10;
                                        Object obj11;
                                        m mVar3 = fVar4.a(c.LEFT).hv;
                                        m mVar4 = fVar4.a(c.RIGHT).hv;
                                        if (fVar4.a(c.LEFT).hy != null) {
                                            if (fVar4.a(c.RIGHT).hy != null) {
                                                obj8 = 1;
                                                mVar = fVar4.a(c.TOP).hv;
                                                mVar2 = fVar4.a(c.BOTTOM).hv;
                                                if (fVar4.a(c.TOP).hy != null) {
                                                    if (fVar4.a(c.BOTTOM).hy != null) {
                                                        obj9 = 1;
                                                        if (i8 == 0 || mode4 != 0 || r3 == null || obj9 == null) {
                                                            obj4 = null;
                                                            obj3 = this.de.aW() != f.a.WRAP_CONTENT ? 1 : null;
                                                            obj5 = this.de.aX() != f.a.WRAP_CONTENT ? 1 : null;
                                                            if (obj3 == null) {
                                                                fVar4.aM().invalidate();
                                                            }
                                                            if (obj5 == null) {
                                                                fVar4.aN().invalidate();
                                                            }
                                                            if (i8 == 0) {
                                                                if (obj3 != null && fVar4.aI() && r3 != null && mVar3.bg() && mVar4.bg()) {
                                                                    i8 = (int) (mVar4.km - mVar3.km);
                                                                    fVar4.aM().E(i8);
                                                                    obj8 = null;
                                                                } else {
                                                                    obj10 = null;
                                                                    i9 = 1;
                                                                    i6 = getChildMeasureSpec(i, paddingLeft3, -2);
                                                                    i5 = i8;
                                                                    if (mode4 == 0) {
                                                                        if (obj5 != null && fVar4.aJ() && obj9 != null && mVar.bg() && mVar2.bg()) {
                                                                            size3 = (int) (mVar2.km - mVar.km);
                                                                            fVar4.aN().E(size3);
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj4 = 1;
                                                                            obj6 = null;
                                                                            i8 = getChildMeasureSpec(i2, paddingTop3, -2);
                                                                            childAt4.measure(i6, i8);
                                                                            if (this.dv != null) {
                                                                                fVar = this.dv;
                                                                                fVar.gd++;
                                                                            }
                                                                            if (i5 == -2) {
                                                                                z2 = true;
                                                                            } else {
                                                                                z2 = false;
                                                                            }
                                                                            fVar4.il = z2;
                                                                            if (mode4 == -2) {
                                                                                z2 = true;
                                                                            } else {
                                                                                z2 = false;
                                                                            }
                                                                            fVar4.im = z2;
                                                                            i3 = childAt4.getMeasuredWidth();
                                                                            size3 = childAt4.getMeasuredHeight();
                                                                            fVar4.setWidth(i3);
                                                                            fVar4.setHeight(size3);
                                                                            if (obj11 != null) {
                                                                                fVar4.iS = i3;
                                                                            }
                                                                            if (obj4 != null) {
                                                                                fVar4.iT = size3;
                                                                            }
                                                                            if (obj10 != null) {
                                                                                fVar4.aM().E(i3);
                                                                            } else {
                                                                                fVar4.aM().state = 2;
                                                                            }
                                                                            if (obj6 != null) {
                                                                                fVar4.aN().E(size3);
                                                                            } else {
                                                                                fVar4.aN().state = 2;
                                                                            }
                                                                            if (layoutParams2.et) {
                                                                                size4 = childAt4.getBaseline();
                                                                                if (size4 != -1) {
                                                                                    fVar4.iR = size4;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (mode4 == -1) {
                                                                        obj6 = obj5;
                                                                        i8 = getChildMeasureSpec(i2, paddingTop3, -1);
                                                                        childAt4.measure(i6, i8);
                                                                        if (this.dv != null) {
                                                                        }
                                                                        if (i5 == -2) {
                                                                        }
                                                                        fVar4.il = z2;
                                                                        if (mode4 == -2) {
                                                                        }
                                                                        fVar4.im = z2;
                                                                        i3 = childAt4.getMeasuredWidth();
                                                                        size3 = childAt4.getMeasuredHeight();
                                                                        fVar4.setWidth(i3);
                                                                        fVar4.setHeight(size3);
                                                                        if (obj11 != null) {
                                                                        }
                                                                        if (obj4 != null) {
                                                                        }
                                                                        if (obj10 != null) {
                                                                        }
                                                                        if (obj6 != null) {
                                                                        }
                                                                        if (layoutParams2.et) {
                                                                        }
                                                                    } else if (mode4 == -2) {
                                                                        obj8 = 1;
                                                                        size3 = mode4;
                                                                    } else {
                                                                        obj8 = null;
                                                                        size3 = mode4;
                                                                    }
                                                                    i8 = getChildMeasureSpec(i2, paddingTop3, size3);
                                                                    obj6 = obj5;
                                                                    obj4 = obj8;
                                                                    mode4 = size3;
                                                                    childAt4.measure(i6, i8);
                                                                    if (this.dv != null) {
                                                                    }
                                                                    if (i5 == -2) {
                                                                    }
                                                                    fVar4.il = z2;
                                                                    if (mode4 == -2) {
                                                                    }
                                                                    fVar4.im = z2;
                                                                    i3 = childAt4.getMeasuredWidth();
                                                                    size3 = childAt4.getMeasuredHeight();
                                                                    fVar4.setWidth(i3);
                                                                    fVar4.setHeight(size3);
                                                                    if (obj11 != null) {
                                                                    }
                                                                    if (obj4 != null) {
                                                                    }
                                                                    if (obj10 != null) {
                                                                    }
                                                                    if (obj6 != null) {
                                                                    }
                                                                    if (layoutParams2.et) {
                                                                    }
                                                                }
                                                            } else if (i8 == -1) {
                                                                obj10 = obj3;
                                                                obj11 = null;
                                                                i6 = getChildMeasureSpec(i, paddingLeft3, -1);
                                                                i5 = i8;
                                                                if (mode4 == 0) {
                                                                }
                                                                i8 = getChildMeasureSpec(i2, paddingTop3, size3);
                                                                obj6 = obj5;
                                                                obj4 = obj8;
                                                                mode4 = size3;
                                                                childAt4.measure(i6, i8);
                                                                if (this.dv != null) {
                                                                }
                                                                if (i5 == -2) {
                                                                }
                                                                fVar4.il = z2;
                                                                if (mode4 == -2) {
                                                                }
                                                                fVar4.im = z2;
                                                                i3 = childAt4.getMeasuredWidth();
                                                                size3 = childAt4.getMeasuredHeight();
                                                                fVar4.setWidth(i3);
                                                                fVar4.setHeight(size3);
                                                                if (obj11 != null) {
                                                                }
                                                                if (obj4 != null) {
                                                                }
                                                                if (obj10 != null) {
                                                                }
                                                                if (obj6 != null) {
                                                                }
                                                                if (layoutParams2.et) {
                                                                }
                                                            } else if (i8 == -2) {
                                                                obj8 = 1;
                                                            } else {
                                                                obj8 = null;
                                                            }
                                                            obj10 = obj3;
                                                            obj11 = obj8;
                                                            i6 = getChildMeasureSpec(i, paddingLeft3, i8);
                                                            i5 = i8;
                                                            if (mode4 == 0) {
                                                            }
                                                            i8 = getChildMeasureSpec(i2, paddingTop3, size3);
                                                            obj6 = obj5;
                                                            obj4 = obj8;
                                                            mode4 = size3;
                                                            childAt4.measure(i6, i8);
                                                            if (this.dv != null) {
                                                            }
                                                            if (i5 == -2) {
                                                            }
                                                            fVar4.il = z2;
                                                            if (mode4 == -2) {
                                                            }
                                                            fVar4.im = z2;
                                                            i3 = childAt4.getMeasuredWidth();
                                                            size3 = childAt4.getMeasuredHeight();
                                                            fVar4.setWidth(i3);
                                                            fVar4.setHeight(size3);
                                                            if (obj11 != null) {
                                                            }
                                                            if (obj4 != null) {
                                                            }
                                                            if (obj10 != null) {
                                                            }
                                                            if (obj6 != null) {
                                                            }
                                                            if (layoutParams2.et) {
                                                            }
                                                        }
                                                    }
                                                }
                                                obj9 = null;
                                                if (i8 == 0) {
                                                }
                                                obj4 = null;
                                                if (this.de.aW() != f.a.WRAP_CONTENT) {
                                                }
                                                if (this.de.aX() != f.a.WRAP_CONTENT) {
                                                }
                                                if (obj3 == null) {
                                                }
                                                if (obj5 == null) {
                                                }
                                                if (i8 == 0) {
                                                }
                                                obj10 = obj3;
                                                obj11 = obj8;
                                                i6 = getChildMeasureSpec(i, paddingLeft3, i8);
                                                i5 = i8;
                                                if (mode4 == 0) {
                                                }
                                                i8 = getChildMeasureSpec(i2, paddingTop3, size3);
                                                obj6 = obj5;
                                                obj4 = obj8;
                                                mode4 = size3;
                                                childAt4.measure(i6, i8);
                                                if (this.dv != null) {
                                                }
                                                if (i5 == -2) {
                                                }
                                                fVar4.il = z2;
                                                if (mode4 == -2) {
                                                }
                                                fVar4.im = z2;
                                                i3 = childAt4.getMeasuredWidth();
                                                size3 = childAt4.getMeasuredHeight();
                                                fVar4.setWidth(i3);
                                                fVar4.setHeight(size3);
                                                if (obj11 != null) {
                                                }
                                                if (obj4 != null) {
                                                }
                                                if (obj10 != null) {
                                                }
                                                if (obj6 != null) {
                                                }
                                                if (layoutParams2.et) {
                                                }
                                            }
                                        }
                                        obj8 = null;
                                        mVar = fVar4.a(c.TOP).hv;
                                        mVar2 = fVar4.a(c.BOTTOM).hv;
                                        if (fVar4.a(c.TOP).hy != null) {
                                        }
                                        obj9 = null;
                                        if (i8 == 0) {
                                        }
                                        obj4 = null;
                                        if (this.de.aW() != f.a.WRAP_CONTENT) {
                                        }
                                        if (this.de.aX() != f.a.WRAP_CONTENT) {
                                        }
                                        if (obj3 == null) {
                                        }
                                        if (obj5 == null) {
                                        }
                                        if (i8 == 0) {
                                        }
                                        obj10 = obj3;
                                        obj11 = obj8;
                                        i6 = getChildMeasureSpec(i, paddingLeft3, i8);
                                        i5 = i8;
                                        if (mode4 == 0) {
                                        }
                                        i8 = getChildMeasureSpec(i2, paddingTop3, size3);
                                        obj6 = obj5;
                                        obj4 = obj8;
                                        mode4 = size3;
                                        childAt4.measure(i6, i8);
                                        if (this.dv != null) {
                                        }
                                        if (i5 == -2) {
                                        }
                                        fVar4.il = z2;
                                        if (mode4 == -2) {
                                        }
                                        fVar4.im = z2;
                                        i3 = childAt4.getMeasuredWidth();
                                        size3 = childAt4.getMeasuredHeight();
                                        fVar4.setWidth(i3);
                                        fVar4.setHeight(size3);
                                        if (obj11 != null) {
                                        }
                                        if (obj4 != null) {
                                        }
                                        if (obj10 != null) {
                                        }
                                        if (obj6 != null) {
                                        }
                                        if (layoutParams2.et) {
                                        }
                                    }
                                }
                            }
                            size4 = i10 + 1;
                        }
                    }
                }
            }
        } else {
            i6 = getPaddingTop() + getPaddingBottom();
            i5 = getPaddingLeft() + getPaddingRight();
            i4 = getChildCount();
            for (paddingLeft2 = 0; paddingLeft2 < i4; paddingLeft2++) {
                View childAt5 = getChildAt(paddingLeft2);
                if (childAt5.getVisibility() != 8) {
                    layoutParams2 = (LayoutParams) childAt5.getLayoutParams();
                    f fVar5 = layoutParams2.eH;
                    if (!(layoutParams2.eu || layoutParams2.ev)) {
                        Object obj12;
                        fVar5.iZ = childAt5.getVisibility();
                        paddingTop2 = layoutParams2.width;
                        mode4 = layoutParams2.height;
                        if (layoutParams2.er || layoutParams2.es || ((!layoutParams2.er && layoutParams2.ee == 1) || layoutParams2.width == -1 || (!layoutParams2.es && (layoutParams2.ef == 1 || layoutParams2.height == -1)))) {
                            obj6 = 1;
                        } else {
                            obj6 = null;
                        }
                        obj8 = null;
                        if (obj6 != null) {
                            if (paddingTop2 == 0) {
                                obj4 = 1;
                                i9 = getChildMeasureSpec(i, i5, -2);
                            } else if (paddingTop2 == -1) {
                                i9 = getChildMeasureSpec(i, i5, -1);
                                obj4 = null;
                            } else {
                                if (paddingTop2 == -2) {
                                    obj8 = 1;
                                }
                                i9 = getChildMeasureSpec(i, i5, paddingTop2);
                                obj4 = obj8;
                            }
                            if (mode4 == 0) {
                                i7 = getChildMeasureSpec(i2, i6, -2);
                                obj12 = 1;
                            } else if (mode4 == -1) {
                                i7 = getChildMeasureSpec(i2, i6, -1);
                                obj12 = null;
                            } else {
                                if (mode4 == -2) {
                                    obj8 = 1;
                                } else {
                                    obj8 = null;
                                }
                                i7 = getChildMeasureSpec(i2, i6, mode4);
                                obj12 = obj8;
                            }
                            childAt5.measure(i9, i7);
                            if (this.dv != null) {
                                fVar = this.dv;
                                fVar.gd++;
                            }
                            if (paddingTop2 == -2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            fVar5.il = z2;
                            if (mode4 == -2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            fVar5.im = z2;
                            mode4 = childAt5.getMeasuredWidth();
                            obj8 = obj4;
                            i7 = childAt5.getMeasuredHeight();
                            paddingTop2 = mode4;
                        } else {
                            obj12 = null;
                            i7 = mode4;
                        }
                        fVar5.setWidth(paddingTop2);
                        fVar5.setHeight(i7);
                        if (obj8 != null) {
                            fVar5.iS = paddingTop2;
                        }
                        if (obj12 != null) {
                            fVar5.iT = i7;
                        }
                        if (layoutParams2.et) {
                            size4 = childAt5.getBaseline();
                            if (size4 != -1) {
                                fVar5.iR = size4;
                            }
                        }
                    }
                }
            }
        }
        i7 = getChildCount();
        for (size3 = 0; size3 < i7; size3++) {
            childAt = getChildAt(size3);
            if (childAt instanceof Placeholder) {
                Placeholder placeholder2 = (Placeholder) childAt;
                if (placeholder2.fs != null) {
                    layoutParams = (LayoutParams) placeholder2.getLayoutParams();
                    layoutParams2 = (LayoutParams) placeholder2.fs.getLayoutParams();
                    layoutParams2.eH.iZ = 0;
                    layoutParams.eH.setWidth(layoutParams2.eH.getWidth());
                    layoutParams.eH.setHeight(layoutParams2.eH.getHeight());
                    layoutParams2.eH.iZ = 8;
                }
            }
        }
        i3 = this.dc.size();
        if (i3 > 0) {
            for (size4 = 0; size4 < i3; size4++) {
                this.dc.get(size4);
            }
        }
        if (getChildCount() > 0 && obj7 != null) {
            android.support.constraint.a.a.a.a(this.de);
        }
        if (this.de.jG) {
            if (this.de.jH && mode == Integer.MIN_VALUE) {
                if (this.de.jJ < size) {
                    this.de.setWidth(this.de.jJ);
                }
                this.de.a(f.a.FIXED);
            }
            if (this.de.jI && mode2 == Integer.MIN_VALUE) {
                if (this.de.jK < size2) {
                    this.de.setHeight(this.de.jK);
                }
                this.de.b(f.a.FIXED);
            }
        }
        if ((this.dl & 32) == 32) {
            size4 = this.de.getWidth();
            i3 = this.de.getHeight();
            if (this.dp != size4 && mode == 1073741824) {
                android.support.constraint.a.a.a.a(this.de.jF, 0, size4);
            }
            if (this.dq != i3 && mode2 == 1073741824) {
                android.support.constraint.a.a.a.a(this.de.jF, 1, i3);
            }
            if (this.de.jH && this.de.jJ > size) {
                android.support.constraint.a.a.a.a(this.de.jF, 0, size);
            }
            if (this.de.jI && this.de.jK > size2) {
                android.support.constraint.a.a.a.a(this.de.jF, 1, size2);
            }
        }
        if (getChildCount() > 0) {
            ar();
        }
        i9 = 0;
        i5 = this.dd.size();
        i4 = paddingTop + getPaddingBottom();
        i10 = paddingLeft + getPaddingRight();
        if (i5 > 0) {
            obj5 = null;
            obj3 = this.de.aW() == f.a.WRAP_CONTENT ? 1 : null;
            if (this.de.aX() == f.a.WRAP_CONTENT) {
                obj6 = 1;
            } else {
                obj6 = null;
            }
            mode4 = Math.max(this.de.getWidth(), this.dg);
            paddingLeft2 = Math.max(this.de.getHeight(), this.dh);
            i6 = 0;
            while (i6 < i5) {
                b = (f) this.dd.get(i6);
                view = (View) b.iX;
                if (view != null) {
                    LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
                    if (!(layoutParams4.ev || layoutParams4.eu || view.getVisibility() == 8 || (obj2 != null && b.aM().bg() && b.aN().bg()))) {
                        Object obj13;
                        if (layoutParams4.width == -2 && layoutParams4.er) {
                            i8 = getChildMeasureSpec(i, i10, layoutParams4.width);
                        } else {
                            i8 = MeasureSpec.makeMeasureSpec(b.getWidth(), ErrorDialogData.SUPPRESSED);
                        }
                        if (layoutParams4.height == -2 && layoutParams4.es) {
                            mode3 = getChildMeasureSpec(i2, i4, layoutParams4.height);
                        } else {
                            mode3 = MeasureSpec.makeMeasureSpec(b.getHeight(), ErrorDialogData.SUPPRESSED);
                        }
                        view.measure(i8, mode3);
                        if (this.dv != null) {
                            android.support.constraint.a.f fVar6 = this.dv;
                            fVar6.ge++;
                        }
                        i8 = view.getMeasuredWidth();
                        mode = view.getMeasuredHeight();
                        if (i8 != b.getWidth()) {
                            b.setWidth(i8);
                            if (obj2 != null) {
                                b.aM().E(i8);
                            }
                            if (obj3 == null || b.getRight() <= mode4) {
                                i8 = mode4;
                            } else {
                                i8 = Math.max(mode4, b.getRight() + b.a(c.RIGHT).aH());
                            }
                            obj4 = 1;
                        } else {
                            i8 = mode4;
                            obj4 = obj5;
                        }
                        if (mode != b.getHeight()) {
                            b.setHeight(mode);
                            if (obj2 != null) {
                                b.aN().E(mode);
                            }
                            if (obj6 == null || b.getBottom() <= paddingLeft2) {
                                mode3 = paddingLeft2;
                            } else {
                                mode3 = Math.max(paddingLeft2, b.getBottom() + b.a(c.BOTTOM).aH());
                            }
                            obj13 = 1;
                            paddingLeft2 = mode3;
                        } else {
                            obj13 = obj4;
                        }
                        if (layoutParams4.et) {
                            childCount = view.getBaseline();
                            if (!(childCount == -1 || childCount == b.iR)) {
                                b.iR = childCount;
                                obj13 = 1;
                            }
                        }
                        if (VERSION.SDK_INT >= 11) {
                            size4 = combineMeasuredStates(i9, view.getMeasuredState());
                            obj5 = obj13;
                        } else {
                            size4 = i9;
                            obj5 = obj13;
                        }
                        i9 = size4;
                        i6++;
                        mode4 = i8;
                    }
                }
                size4 = i9;
                i8 = mode4;
                i9 = size4;
                i6++;
                mode4 = i8;
            }
            if (obj5 != null) {
                this.de.setWidth(width);
                this.de.setHeight(height);
                if (obj2 != null) {
                    this.de.ba();
                }
                ar();
                obj = null;
                if (this.de.getWidth() < mode4) {
                    this.de.setWidth(mode4);
                    obj = 1;
                }
                if (this.de.getHeight() < paddingLeft2) {
                    this.de.setHeight(paddingLeft2);
                    obj = 1;
                }
                if (obj != null) {
                    ar();
                }
            }
            for (childCount = 0; childCount < i5; childCount++) {
                b = (f) this.dd.get(childCount);
                view = (View) b.iX;
                if (!(view == null || ((view.getMeasuredWidth() == b.getWidth() && view.getMeasuredHeight() == b.getHeight()) || b.iZ == 8))) {
                    view.measure(MeasureSpec.makeMeasureSpec(b.getWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(b.getHeight(), ErrorDialogData.SUPPRESSED));
                    if (this.dv != null) {
                        android.support.constraint.a.f fVar7 = this.dv;
                        fVar7.ge++;
                    }
                }
            }
        }
        size4 = this.de.getWidth() + i10;
        i3 = this.de.getHeight() + i4;
        if (VERSION.SDK_INT >= 11) {
            i3 = resolveSizeAndState(i3, i2, i9 << 16) & 16777215;
            size4 = Math.min(this.di, resolveSizeAndState(size4, i, i9) & 16777215);
            i3 = Math.min(this.dj, i3);
            if (this.de.jM) {
                size4 |= 16777216;
            }
            if (this.de.jN) {
                i3 |= 16777216;
            }
            setMeasuredDimension(size4, i3);
            this.dp = size4;
            this.dq = i3;
            return;
        }
        setMeasuredDimension(size4, i3);
        this.dp = size4;
        this.dq = i3;
    }

    private void ar() {
        this.de.aZ();
        if (this.dv != null) {
            android.support.constraint.a.f fVar = this.dv;
            fVar.gf++;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int aO;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            f fVar = layoutParams.eH;
            if ((childAt.getVisibility() != 8 || layoutParams.eu || layoutParams.ev || isInEditMode) && !layoutParams.ew) {
                aO = fVar.aO();
                int aP = fVar.aP();
                int width = fVar.getWidth() + aO;
                int height = fVar.getHeight() + aP;
                childAt.layout(aO, aP, width, height);
                if (childAt instanceof Placeholder) {
                    childAt = ((Placeholder) childAt).getContent();
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        childAt.layout(aO, aP, width, height);
                    }
                }
            }
        }
        i5 = this.dc.size();
        if (i5 > 0) {
            for (aO = 0; aO < i5; aO++) {
                ((ConstraintHelper) this.dc.get(aO)).aq();
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.de.dl = i;
    }

    public int getOptimizationLevel() {
        return this.de.dl;
    }

    protected static LayoutParams as() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(a aVar) {
        this.dm = aVar;
    }

    public final View q(int i) {
        return (View) this.db.get(i);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                            int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            canvas.drawLine((float) i2, (float) i3, (float) (i2 + parseInt3), (float) i3, paint);
                            Canvas canvas2 = canvas;
                            canvas2.drawLine((float) (i2 + parseInt3), (float) i3, (float) (i2 + parseInt3), (float) (i3 + parseInt4), paint);
                            canvas2 = canvas;
                            canvas2.drawLine((float) (i2 + parseInt3), (float) (i3 + parseInt4), (float) i2, (float) (i3 + parseInt4), paint);
                            canvas.drawLine((float) i2, (float) (i3 + parseInt4), (float) i2, (float) i3, paint);
                            paint.setColor(-16711936);
                            canvas2 = canvas;
                            canvas2.drawLine((float) i2, (float) i3, (float) (i2 + parseInt3), (float) (i3 + parseInt4), paint);
                            canvas.drawLine((float) i2, (float) (i3 + parseInt4), (float) (i2 + parseInt3), (float) i3, paint);
                        }
                    }
                }
            }
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.dk = true;
        this.dp = -1;
        this.dq = -1;
        this.dr = -1;
        this.ds = -1;
        this.dt = 0;
        this.du = 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
