package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.C25290b.C25291a;
import android.support.constraint.C37095a.C31827a;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.p781a.C17368f;
import android.support.constraint.p780a.p781a.C17368f.C17370a;
import android.support.constraint.p780a.p781a.C25284e.C25285b;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import android.support.constraint.p780a.p781a.C31242g;
import android.support.constraint.p780a.p781a.C41470a;
import android.support.constraint.p780a.p781a.C41471i;
import android.support.constraint.p780a.p781a.C41476m;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xwalk.core.XWalkEnvironment;

public class ConstraintLayout extends ViewGroup {
    /* renamed from: db */
    SparseArray<View> f16606db = new SparseArray();
    /* renamed from: dc */
    private ArrayList<ConstraintHelper> f16607dc = new ArrayList(4);
    /* renamed from: dd */
    private final ArrayList<C17368f> f16608dd = new ArrayList(100);
    /* renamed from: de */
    C31242g f16609de = new C31242g();
    /* renamed from: dg */
    private int f16610dg = 0;
    /* renamed from: dh */
    private int f16611dh = 0;
    /* renamed from: di */
    private int f16612di = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: dj */
    private int f16613dj = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: dk */
    private boolean f16614dk = true;
    /* renamed from: dl */
    private int f16615dl = 7;
    /* renamed from: dm */
    private C37095a f16616dm = null;
    /* renamed from: dn */
    private int f16617dn = -1;
    /* renamed from: do */
    private HashMap<String, Integer> f16618do = new HashMap();
    /* renamed from: dp */
    private int f16619dp = -1;
    /* renamed from: dq */
    private int f16620dq = -1;
    /* renamed from: dr */
    int f16621dr = -1;
    /* renamed from: ds */
    int f16622ds = -1;
    /* renamed from: dt */
    int f16623dt = 0;
    /* renamed from: du */
    int f16624du = 0;
    /* renamed from: dv */
    private C41477f f16625dv;

    public static class LayoutParams extends MarginLayoutParams {
        /* renamed from: dA */
        public float f14416dA = -1.0f;
        /* renamed from: dB */
        public int f14417dB = -1;
        /* renamed from: dC */
        public int f14418dC = -1;
        /* renamed from: dD */
        public int f14419dD = -1;
        /* renamed from: dE */
        public int f14420dE = -1;
        /* renamed from: dF */
        public int f14421dF = -1;
        /* renamed from: dG */
        public int f14422dG = -1;
        /* renamed from: dH */
        public int f14423dH = -1;
        /* renamed from: dI */
        public int f14424dI = -1;
        /* renamed from: dJ */
        public int f14425dJ = -1;
        /* renamed from: dK */
        public int f14426dK = -1;
        /* renamed from: dL */
        public int f14427dL = 0;
        /* renamed from: dM */
        public float f14428dM = 0.0f;
        /* renamed from: dN */
        public int f14429dN = -1;
        /* renamed from: dO */
        public int f14430dO = -1;
        /* renamed from: dP */
        public int f14431dP = -1;
        /* renamed from: dQ */
        public int f14432dQ = -1;
        /* renamed from: dR */
        public int f14433dR = -1;
        /* renamed from: dS */
        public int f14434dS = -1;
        /* renamed from: dT */
        public int f14435dT = -1;
        /* renamed from: dU */
        public int f14436dU = -1;
        /* renamed from: dV */
        public int f14437dV = -1;
        /* renamed from: dW */
        public int f14438dW = -1;
        /* renamed from: dX */
        public float f14439dX = 0.5f;
        /* renamed from: dY */
        public float f14440dY = 0.5f;
        /* renamed from: dZ */
        public String f14441dZ = null;
        /* renamed from: dw */
        public int f14442dw = -1;
        /* renamed from: dz */
        public int f14443dz = -1;
        /* renamed from: eA */
        int f14444eA = -1;
        /* renamed from: eB */
        int f14445eB = -1;
        /* renamed from: eC */
        int f14446eC = -1;
        /* renamed from: eD */
        float f14447eD = 0.5f;
        /* renamed from: eE */
        int f14448eE;
        /* renamed from: eF */
        int f14449eF;
        /* renamed from: eG */
        float f14450eG;
        /* renamed from: eH */
        C17368f f14451eH = new C17368f();
        /* renamed from: eI */
        public boolean f14452eI = false;
        /* renamed from: ea */
        float f14453ea = 0.0f;
        /* renamed from: eb */
        int f14454eb = 1;
        /* renamed from: ec */
        public int f14455ec = 0;
        /* renamed from: ed */
        public int f14456ed = 0;
        /* renamed from: ee */
        public int f14457ee = 0;
        /* renamed from: ef */
        public int f14458ef = 0;
        /* renamed from: eg */
        public int f14459eg = 0;
        /* renamed from: eh */
        public int f14460eh = 0;
        /* renamed from: ei */
        public int f14461ei = 0;
        /* renamed from: ej */
        public int f14462ej = 0;
        /* renamed from: ek */
        public float f14463ek = 1.0f;
        /* renamed from: el */
        public float f14464el = 1.0f;
        /* renamed from: em */
        public int f14465em = -1;
        /* renamed from: eo */
        public int f14466eo = -1;
        /* renamed from: ep */
        public boolean f14467ep = false;
        /* renamed from: eq */
        public boolean f14468eq = false;
        /* renamed from: er */
        boolean f14469er = true;
        /* renamed from: es */
        boolean f14470es = true;
        /* renamed from: et */
        boolean f14471et = false;
        /* renamed from: eu */
        boolean f14472eu = false;
        /* renamed from: ev */
        boolean f14473ev = false;
        /* renamed from: ew */
        boolean f14474ew = false;
        /* renamed from: ex */
        int f14475ex = -1;
        /* renamed from: ey */
        int f14476ey = -1;
        /* renamed from: ez */
        int f14477ez = -1;
        public float horizontalWeight = -1.0f;
        public int orientation = -1;
        public float verticalWeight = -1.0f;

        /* renamed from: android.support.constraint.ConstraintLayout$LayoutParams$a */
        static class C17366a {
            /* renamed from: eJ */
            public static final SparseIntArray f3606eJ;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f3606eJ = sparseIntArray;
                sparseIntArray.append(34, 8);
                f3606eJ.append(35, 9);
                f3606eJ.append(37, 10);
                f3606eJ.append(38, 11);
                f3606eJ.append(43, 12);
                f3606eJ.append(42, 13);
                f3606eJ.append(16, 14);
                f3606eJ.append(15, 15);
                f3606eJ.append(13, 16);
                f3606eJ.append(17, 2);
                f3606eJ.append(19, 3);
                f3606eJ.append(18, 4);
                f3606eJ.append(51, 49);
                f3606eJ.append(52, 50);
                f3606eJ.append(23, 5);
                f3606eJ.append(24, 6);
                f3606eJ.append(25, 7);
                f3606eJ.append(0, 1);
                f3606eJ.append(39, 17);
                f3606eJ.append(40, 18);
                f3606eJ.append(22, 19);
                f3606eJ.append(21, 20);
                f3606eJ.append(55, 21);
                f3606eJ.append(58, 22);
                f3606eJ.append(56, 23);
                f3606eJ.append(53, 24);
                f3606eJ.append(57, 25);
                f3606eJ.append(54, 26);
                f3606eJ.append(30, 29);
                f3606eJ.append(44, 30);
                f3606eJ.append(20, 44);
                f3606eJ.append(32, 45);
                f3606eJ.append(46, 46);
                f3606eJ.append(31, 47);
                f3606eJ.append(45, 48);
                f3606eJ.append(11, 27);
                f3606eJ.append(10, 28);
                f3606eJ.append(47, 31);
                f3606eJ.append(26, 32);
                f3606eJ.append(49, 33);
                f3606eJ.append(48, 34);
                f3606eJ.append(50, 35);
                f3606eJ.append(28, 36);
                f3606eJ.append(27, 37);
                f3606eJ.append(29, 38);
                f3606eJ.append(33, 39);
                f3606eJ.append(41, 40);
                f3606eJ.append(36, 41);
                f3606eJ.append(14, 42);
                f3606eJ.append(12, 43);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25291a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (C17366a.f3606eJ.get(index)) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        this.f14426dK = obtainStyledAttributes.getResourceId(index, this.f14426dK);
                        if (this.f14426dK != -1) {
                            break;
                        }
                        this.f14426dK = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 3:
                        this.f14427dL = obtainStyledAttributes.getDimensionPixelSize(index, this.f14427dL);
                        break;
                    case 4:
                        this.f14428dM = obtainStyledAttributes.getFloat(index, this.f14428dM) % 360.0f;
                        if (this.f14428dM >= 0.0f) {
                            break;
                        }
                        this.f14428dM = (360.0f - this.f14428dM) % 360.0f;
                        break;
                    case 5:
                        this.f14442dw = obtainStyledAttributes.getDimensionPixelOffset(index, this.f14442dw);
                        break;
                    case 6:
                        this.f14443dz = obtainStyledAttributes.getDimensionPixelOffset(index, this.f14443dz);
                        break;
                    case 7:
                        this.f14416dA = obtainStyledAttributes.getFloat(index, this.f14416dA);
                        break;
                    case 8:
                        this.f14417dB = obtainStyledAttributes.getResourceId(index, this.f14417dB);
                        if (this.f14417dB != -1) {
                            break;
                        }
                        this.f14417dB = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 9:
                        this.f14418dC = obtainStyledAttributes.getResourceId(index, this.f14418dC);
                        if (this.f14418dC != -1) {
                            break;
                        }
                        this.f14418dC = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 10:
                        this.f14419dD = obtainStyledAttributes.getResourceId(index, this.f14419dD);
                        if (this.f14419dD != -1) {
                            break;
                        }
                        this.f14419dD = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 11:
                        this.f14420dE = obtainStyledAttributes.getResourceId(index, this.f14420dE);
                        if (this.f14420dE != -1) {
                            break;
                        }
                        this.f14420dE = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 12:
                        this.f14421dF = obtainStyledAttributes.getResourceId(index, this.f14421dF);
                        if (this.f14421dF != -1) {
                            break;
                        }
                        this.f14421dF = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 13:
                        this.f14422dG = obtainStyledAttributes.getResourceId(index, this.f14422dG);
                        if (this.f14422dG != -1) {
                            break;
                        }
                        this.f14422dG = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 14:
                        this.f14423dH = obtainStyledAttributes.getResourceId(index, this.f14423dH);
                        if (this.f14423dH != -1) {
                            break;
                        }
                        this.f14423dH = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 15:
                        this.f14424dI = obtainStyledAttributes.getResourceId(index, this.f14424dI);
                        if (this.f14424dI != -1) {
                            break;
                        }
                        this.f14424dI = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 16:
                        this.f14425dJ = obtainStyledAttributes.getResourceId(index, this.f14425dJ);
                        if (this.f14425dJ != -1) {
                            break;
                        }
                        this.f14425dJ = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 17:
                        this.f14429dN = obtainStyledAttributes.getResourceId(index, this.f14429dN);
                        if (this.f14429dN != -1) {
                            break;
                        }
                        this.f14429dN = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 18:
                        this.f14430dO = obtainStyledAttributes.getResourceId(index, this.f14430dO);
                        if (this.f14430dO != -1) {
                            break;
                        }
                        this.f14430dO = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 19:
                        this.f14431dP = obtainStyledAttributes.getResourceId(index, this.f14431dP);
                        if (this.f14431dP != -1) {
                            break;
                        }
                        this.f14431dP = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 20:
                        this.f14432dQ = obtainStyledAttributes.getResourceId(index, this.f14432dQ);
                        if (this.f14432dQ != -1) {
                            break;
                        }
                        this.f14432dQ = obtainStyledAttributes.getInt(index, -1);
                        break;
                    case 21:
                        this.f14433dR = obtainStyledAttributes.getDimensionPixelSize(index, this.f14433dR);
                        break;
                    case 22:
                        this.f14434dS = obtainStyledAttributes.getDimensionPixelSize(index, this.f14434dS);
                        break;
                    case 23:
                        this.f14435dT = obtainStyledAttributes.getDimensionPixelSize(index, this.f14435dT);
                        break;
                    case 24:
                        this.f14436dU = obtainStyledAttributes.getDimensionPixelSize(index, this.f14436dU);
                        break;
                    case 25:
                        this.f14437dV = obtainStyledAttributes.getDimensionPixelSize(index, this.f14437dV);
                        break;
                    case 26:
                        this.f14438dW = obtainStyledAttributes.getDimensionPixelSize(index, this.f14438dW);
                        break;
                    case 27:
                        this.f14467ep = obtainStyledAttributes.getBoolean(index, this.f14467ep);
                        break;
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        this.f14468eq = obtainStyledAttributes.getBoolean(index, this.f14468eq);
                        break;
                    case 29:
                        this.f14439dX = obtainStyledAttributes.getFloat(index, this.f14439dX);
                        break;
                    case 30:
                        this.f14440dY = obtainStyledAttributes.getFloat(index, this.f14440dY);
                        break;
                    case 31:
                        this.f14457ee = obtainStyledAttributes.getInt(index, 0);
                        if (this.f14457ee == 1) {
                        }
                        break;
                    case 32:
                        this.f14458ef = obtainStyledAttributes.getInt(index, 0);
                        if (this.f14458ef == 1) {
                        }
                        break;
                    case 33:
                        try {
                            this.f14459eg = obtainStyledAttributes.getDimensionPixelSize(index, this.f14459eg);
                            break;
                        } catch (Exception e) {
                            if (obtainStyledAttributes.getInt(index, this.f14459eg) != -2) {
                                break;
                            }
                            this.f14459eg = -2;
                            break;
                        }
                    case 34:
                        try {
                            this.f14461ei = obtainStyledAttributes.getDimensionPixelSize(index, this.f14461ei);
                            break;
                        } catch (Exception e2) {
                            if (obtainStyledAttributes.getInt(index, this.f14461ei) != -2) {
                                break;
                            }
                            this.f14461ei = -2;
                            break;
                        }
                    case 35:
                        this.f14463ek = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f14463ek));
                        break;
                    case 36:
                        try {
                            this.f14460eh = obtainStyledAttributes.getDimensionPixelSize(index, this.f14460eh);
                            break;
                        } catch (Exception e3) {
                            if (obtainStyledAttributes.getInt(index, this.f14460eh) != -2) {
                                break;
                            }
                            this.f14460eh = -2;
                            break;
                        }
                    case C2275g.CTRL_INDEX /*37*/:
                        try {
                            this.f14462ej = obtainStyledAttributes.getDimensionPixelSize(index, this.f14462ej);
                            break;
                        } catch (Exception e4) {
                            if (obtainStyledAttributes.getInt(index, this.f14462ej) != -2) {
                                break;
                            }
                            this.f14462ej = -2;
                            break;
                        }
                    case 38:
                        this.f14464el = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f14464el));
                        break;
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        this.f14441dZ = obtainStyledAttributes.getString(index);
                        this.f14453ea = Float.NaN;
                        this.f14454eb = -1;
                        if (this.f14441dZ == null) {
                            break;
                        }
                        int length = this.f14441dZ.length();
                        index = this.f14441dZ.indexOf(44);
                        if (index <= 0 || index >= length - 1) {
                            index = 0;
                        } else {
                            String substring = this.f14441dZ.substring(0, index);
                            if (substring.equalsIgnoreCase(QLog.TAG_REPORTLEVEL_COLORUSER)) {
                                this.f14454eb = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.f14454eb = 1;
                            }
                            index++;
                        }
                        int indexOf = this.f14441dZ.indexOf(58);
                        String substring2;
                        if (indexOf >= 0 && indexOf < length - 1) {
                            substring2 = this.f14441dZ.substring(index, indexOf);
                            String substring3 = this.f14441dZ.substring(indexOf + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.f14454eb != 1) {
                                            this.f14453ea = Math.abs(parseFloat / parseFloat2);
                                            break;
                                        } else {
                                            this.f14453ea = Math.abs(parseFloat2 / parseFloat);
                                            break;
                                        }
                                    }
                                } catch (NumberFormatException e5) {
                                    break;
                                }
                            }
                        }
                        substring2 = this.f14441dZ.substring(index);
                        if (substring2.length() <= 0) {
                            break;
                        }
                        try {
                            this.f14453ea = Float.parseFloat(substring2);
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
                        this.f14455ec = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.f14456ed = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        this.f14465em = obtainStyledAttributes.getDimensionPixelOffset(index, this.f14465em);
                        break;
                    case 50:
                        this.f14466eo = obtainStyledAttributes.getDimensionPixelOffset(index, this.f14466eo);
                        break;
                    default:
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public final void validate() {
            this.f14472eu = false;
            this.f14469er = true;
            this.f14470es = true;
            if (this.width == -2 && this.f14467ep) {
                this.f14469er = false;
                this.f14457ee = 1;
            }
            if (this.height == -2 && this.f14468eq) {
                this.f14470es = false;
                this.f14458ef = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f14469er = false;
                if (this.width == 0 && this.f14457ee == 1) {
                    this.width = -2;
                    this.f14467ep = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f14470es = false;
                if (this.height == 0 && this.f14458ef == 1) {
                    this.height = -2;
                    this.f14468eq = true;
                }
            }
            if (this.f14416dA != -1.0f || this.f14442dw != -1 || this.f14443dz != -1) {
                this.f14472eu = true;
                this.f14469er = true;
                this.f14470es = true;
                if (!(this.f14451eH instanceof C41471i)) {
                    this.f14451eH = new C41471i();
                }
                ((C41471i) this.f14451eH).setOrientation(this.orientation);
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
            this.f14477ez = -1;
            this.f14444eA = -1;
            this.f14475ex = -1;
            this.f14476ey = -1;
            this.f14445eB = -1;
            this.f14446eC = -1;
            this.f14445eB = this.f14433dR;
            this.f14446eC = this.f14435dT;
            this.f14447eD = this.f14439dX;
            this.f14448eE = this.f14442dw;
            this.f14449eF = this.f14443dz;
            this.f14450eG = this.f14416dA;
            if ((1 == getLayoutDirection() ? 1 : null) != null) {
                if (this.f14429dN != -1) {
                    this.f14477ez = this.f14429dN;
                    obj = 1;
                } else if (this.f14430dO != -1) {
                    this.f14444eA = this.f14430dO;
                    int obj2 = 1;
                }
                if (this.f14431dP != -1) {
                    this.f14476ey = this.f14431dP;
                    obj2 = 1;
                }
                if (this.f14432dQ != -1) {
                    this.f14475ex = this.f14432dQ;
                    obj2 = 1;
                }
                if (this.f14437dV != -1) {
                    this.f14446eC = this.f14437dV;
                }
                if (this.f14438dW != -1) {
                    this.f14445eB = this.f14438dW;
                }
                if (obj2 != null) {
                    this.f14447eD = 1.0f - this.f14439dX;
                }
                if (this.f14472eu && this.orientation == 1) {
                    if (this.f14416dA != -1.0f) {
                        this.f14450eG = 1.0f - this.f14416dA;
                        this.f14448eE = -1;
                        this.f14449eF = -1;
                    } else if (this.f14442dw != -1) {
                        this.f14449eF = this.f14442dw;
                        this.f14448eE = -1;
                        this.f14450eG = -1.0f;
                    } else if (this.f14443dz != -1) {
                        this.f14448eE = this.f14443dz;
                        this.f14449eF = -1;
                        this.f14450eG = -1.0f;
                    }
                }
            } else {
                if (this.f14429dN != -1) {
                    this.f14476ey = this.f14429dN;
                }
                if (this.f14430dO != -1) {
                    this.f14475ex = this.f14430dO;
                }
                if (this.f14431dP != -1) {
                    this.f14477ez = this.f14431dP;
                }
                if (this.f14432dQ != -1) {
                    this.f14444eA = this.f14432dQ;
                }
                if (this.f14437dV != -1) {
                    this.f14445eB = this.f14437dV;
                }
                if (this.f14438dW != -1) {
                    this.f14446eC = this.f14438dW;
                }
            }
            if (this.f14431dP == -1 && this.f14432dQ == -1 && this.f14430dO == -1 && this.f14429dN == -1) {
                if (this.f14419dD != -1) {
                    this.f14477ez = this.f14419dD;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else if (this.f14420dE != -1) {
                    this.f14444eA = this.f14420dE;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                }
                if (this.f14417dB != -1) {
                    this.f14475ex = this.f14417dB;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                } else if (this.f14418dC != -1) {
                    this.f14476ey = this.f14418dC;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m72363c(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f16618do == null) {
                this.f16618do = new HashMap();
            }
            obj = (String) obj;
            int indexOf = obj.indexOf("/");
            if (indexOf != -1) {
                obj = obj.substring(indexOf + 1);
            }
            this.f16618do.put(obj, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* renamed from: f */
    public final Object mo66117f(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (this.f16618do != null && this.f16618do.containsKey(str)) {
                return this.f16618do.get(str);
            }
        }
        return null;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m72362b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m72362b(attributeSet);
    }

    public void setId(int i) {
        this.f16606db.remove(getId());
        super.setId(i);
        this.f16606db.put(getId(), this);
    }

    /* renamed from: b */
    private void m72362b(AttributeSet attributeSet) {
        this.f16609de.f3636iX = this;
        this.f16606db.put(getId(), this);
        this.f16616dm = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C25291a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 3) {
                    this.f16610dg = obtainStyledAttributes.getDimensionPixelOffset(index, this.f16610dg);
                } else if (index == 4) {
                    this.f16611dh = obtainStyledAttributes.getDimensionPixelOffset(index, this.f16611dh);
                } else if (index == 1) {
                    this.f16612di = obtainStyledAttributes.getDimensionPixelOffset(index, this.f16612di);
                } else if (index == 2) {
                    this.f16613dj = obtainStyledAttributes.getDimensionPixelOffset(index, this.f16613dj);
                } else if (index == 59) {
                    this.f16615dl = obtainStyledAttributes.getInt(index, this.f16615dl);
                } else if (index == 8) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f16616dm = new C37095a();
                        C37095a c37095a = this.f16616dm;
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
                                        C31827a c31827a = new C31827a();
                                        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(asAttributeSet, C25291a.ConstraintSet);
                                        C37095a.m62054a(c31827a, obtainStyledAttributes2);
                                        obtainStyledAttributes2.recycle();
                                        if (name.equalsIgnoreCase("Guideline")) {
                                            c31827a.f14506eN = true;
                                        }
                                        c37095a.f15657eL.put(Integer.valueOf(c31827a.f14507eO), c31827a);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (IOException | XmlPullParserException e) {
                        }
                    } catch (NotFoundException e2) {
                        this.f16616dm = null;
                    }
                    this.f16617dn = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f16609de.f14370dl = this.f16615dl;
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
        C17368f b = mo66114b(view);
        if ((view instanceof Guideline) && !(b instanceof C41471i)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f14451eH = new C41471i();
            layoutParams.f14472eu = true;
            ((C41471i) layoutParams.f14451eH).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.mo66107ap();
            ((LayoutParams) view.getLayoutParams()).f14473ev = true;
            if (!this.f16607dc.contains(constraintHelper)) {
                this.f16607dc.add(constraintHelper);
            }
        }
        this.f16606db.put(view.getId(), view);
        this.f16614dk = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f16606db.remove(view.getId());
        C17368f b = mo66114b(view);
        this.f16609de.mo42150f(b);
        this.f16607dc.remove(view);
        this.f16608dd.remove(b);
        this.f16614dk = true;
    }

    public void setMinWidth(int i) {
        if (i != this.f16610dg) {
            this.f16610dg = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f16611dh) {
            this.f16611dh = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f16610dg;
    }

    public int getMinHeight() {
        return this.f16611dh;
    }

    public void setMaxWidth(int i) {
        if (i != this.f16612di) {
            this.f16612di = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.f16613dj) {
            this.f16613dj = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f16612di;
    }

    public int getMaxHeight() {
        return this.f16613dj;
    }

    /* renamed from: p */
    private final C17368f m72364p(int i) {
        if (i == 0) {
            return this.f16609de;
        }
        View view = (View) this.f16606db.get(i);
        if (view == null) {
            view = findViewById(i);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.f16609de;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).f14451eH;
    }

    /* renamed from: b */
    public final C17368f mo66114b(View view) {
        if (view == this) {
            return this.f16609de;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).f14451eH;
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
        C17368f b;
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
        this.f16609de.setX(paddingLeft);
        this.f16609de.setY(paddingTop);
        this.f16609de.f3654is[0] = this.f16612di;
        this.f16609de.f3654is[1] = this.f16613dj;
        if (VERSION.SDK_INT >= 17) {
            boolean z;
            C31242g c31242g = this.f16609de;
            if (getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            c31242g.f14371hq = z;
        }
        int mode3 = MeasureSpec.getMode(i);
        int size3 = MeasureSpec.getSize(i);
        int mode4 = MeasureSpec.getMode(i2);
        int size4 = MeasureSpec.getSize(i2);
        int paddingTop2 = getPaddingTop() + getPaddingBottom();
        int paddingLeft2 = getPaddingLeft() + getPaddingRight();
        C17370a c17370a = C17370a.FIXED;
        C17370a c17370a2 = C17370a.FIXED;
        getLayoutParams();
        switch (mode3) {
            case C8415j.INVALID_ID /*-2147483648*/:
                c17370a = C17370a.WRAP_CONTENT;
                break;
            case 0:
                c17370a = C17370a.WRAP_CONTENT;
                size3 = 0;
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                size3 = Math.min(this.f16612di, size3) - paddingLeft2;
                break;
            default:
                size3 = 0;
                break;
        }
        switch (mode4) {
            case C8415j.INVALID_ID /*-2147483648*/:
                c17370a2 = C17370a.WRAP_CONTENT;
                break;
            case 0:
                c17370a2 = C17370a.WRAP_CONTENT;
                size4 = 0;
                break;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                size4 = Math.min(this.f16613dj, size4) - paddingTop2;
                break;
            default:
                size4 = 0;
                break;
        }
        this.f16609de.setMinWidth(0);
        this.f16609de.setMinHeight(0);
        this.f16609de.mo31447a(c17370a);
        this.f16609de.setWidth(size3);
        this.f16609de.mo31470b(c17370a2);
        this.f16609de.setHeight(size4);
        this.f16609de.setMinWidth((this.f16610dg - getPaddingLeft()) - getPaddingRight());
        this.f16609de.setMinHeight((this.f16611dh - getPaddingTop()) - getPaddingBottom());
        int width = this.f16609de.getWidth();
        int height = this.f16609de.getHeight();
        Object obj7;
        if (this.f16614dk) {
            this.f16614dk = false;
            childCount = getChildCount();
            obj = null;
            i3 = 0;
            while (i3 < childCount) {
                if (getChildAt(i3).isLayoutRequested()) {
                    obj = 1;
                    if (obj != null) {
                        View childAt2;
                        String resourceName;
                        this.f16608dd.clear();
                        boolean isInEditMode = isInEditMode();
                        int childCount2 = getChildCount();
                        if (isInEditMode) {
                            for (size4 = 0; size4 < childCount2; size4++) {
                                childAt2 = getChildAt(size4);
                                try {
                                    resourceName = getResources().getResourceName(childAt2.getId());
                                    m72363c(resourceName, Integer.valueOf(childAt2.getId()));
                                    size3 = resourceName.indexOf(47);
                                    if (size3 != -1) {
                                        resourceName = resourceName.substring(size3 + 1);
                                    }
                                    m72364p(childAt2.getId()).f3661ja = resourceName;
                                } catch (NotFoundException e) {
                                }
                            }
                        }
                        for (size4 = 0; size4 < childCount2; size4++) {
                            C17368f b2 = mo66114b(getChildAt(size4));
                            if (b2 != null) {
                                b2.reset();
                            }
                        }
                        if (this.f16617dn != -1) {
                            size4 = 0;
                            while (true) {
                                i3 = size4;
                                if (i3 < childCount2) {
                                    childAt = getChildAt(i3);
                                    if (childAt.getId() == this.f16617dn && (childAt instanceof Constraints)) {
                                        this.f16616dm = ((Constraints) childAt).getConstraintSet();
                                    }
                                    size4 = i3 + 1;
                                }
                            }
                        }
                        if (this.f16616dm != null) {
                            this.f16616dm.mo59120b(this);
                        }
                        this.f16609de.mo42148bh();
                        childCount = this.f16607dc.size();
                        if (childCount > 0) {
                            for (i3 = 0; i3 < childCount; i3++) {
                                ((ConstraintHelper) this.f16607dc.get(i3)).mo51784a(this);
                            }
                        }
                        size4 = 0;
                        while (true) {
                            childCount = size4;
                            if (childCount < childCount2) {
                                childAt = getChildAt(childCount);
                                if (childAt instanceof Placeholder) {
                                    Placeholder placeholder = (Placeholder) childAt;
                                    if (placeholder.f15633fq == -1 && !placeholder.isInEditMode()) {
                                        placeholder.setVisibility(placeholder.f15635ft);
                                    }
                                    placeholder.f15634fs = findViewById(placeholder.f15633fq);
                                    if (placeholder.f15634fs != null) {
                                        ((LayoutParams) placeholder.f15634fs.getLayoutParams()).f14474ew = true;
                                        placeholder.f15634fs.setVisibility(0);
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
                                        b = mo66114b(childAt2);
                                        if (b != null) {
                                            LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                                            layoutParams3.validate();
                                            if (layoutParams3.f14452eI) {
                                                layoutParams3.f14452eI = false;
                                            } else if (isInEditMode) {
                                                try {
                                                    resourceName = getResources().getResourceName(childAt2.getId());
                                                    m72363c(resourceName, Integer.valueOf(childAt2.getId()));
                                                    m72364p(childAt2.getId()).f3661ja = resourceName.substring(resourceName.indexOf("id/") + 3);
                                                } catch (NotFoundException e2) {
                                                }
                                            }
                                            b.f3638iZ = childAt2.getVisibility();
                                            if (layoutParams3.f14474ew) {
                                                b.f3638iZ = 8;
                                            }
                                            b.f3636iX = childAt2;
                                            this.f16609de.mo42149e(b);
                                            if (!(layoutParams3.f14470es && layoutParams3.f14469er)) {
                                                this.f16608dd.add(b);
                                            }
                                            float f;
                                            if (layoutParams3.f14472eu) {
                                                C41471i c41471i = (C41471i) b;
                                                size3 = layoutParams3.f14448eE;
                                                childCount = layoutParams3.f14449eF;
                                                f = layoutParams3.f14450eG;
                                                if (VERSION.SDK_INT < 17) {
                                                    size3 = layoutParams3.f14442dw;
                                                    childCount = layoutParams3.f14443dz;
                                                    f = layoutParams3.f14416dA;
                                                }
                                                if (f != -1.0f) {
                                                    c41471i.mo66143g(f);
                                                } else if (size3 != -1) {
                                                    c41471i.mo66141B(size3);
                                                } else if (childCount != -1) {
                                                    c41471i.mo66142C(childCount);
                                                }
                                            } else if (layoutParams3.f14417dB != -1 || layoutParams3.f14418dC != -1 || layoutParams3.f14419dD != -1 || layoutParams3.f14420dE != -1 || layoutParams3.f14430dO != -1 || layoutParams3.f14429dN != -1 || layoutParams3.f14431dP != -1 || layoutParams3.f14432dQ != -1 || layoutParams3.f14421dF != -1 || layoutParams3.f14422dG != -1 || layoutParams3.f14423dH != -1 || layoutParams3.f14424dI != -1 || layoutParams3.f14425dJ != -1 || layoutParams3.f14465em != -1 || layoutParams3.f14466eo != -1 || layoutParams3.f14426dK != -1 || layoutParams3.width == -1 || layoutParams3.height == -1) {
                                                float f2;
                                                float f3;
                                                i5 = layoutParams3.f14475ex;
                                                i6 = layoutParams3.f14476ey;
                                                i7 = layoutParams3.f14477ez;
                                                size3 = layoutParams3.f14444eA;
                                                i8 = layoutParams3.f14445eB;
                                                childCount = layoutParams3.f14446eC;
                                                f = layoutParams3.f14447eD;
                                                if (VERSION.SDK_INT < 17) {
                                                    i5 = layoutParams3.f14417dB;
                                                    i6 = layoutParams3.f14418dC;
                                                    i7 = layoutParams3.f14419dD;
                                                    size3 = layoutParams3.f14420dE;
                                                    i8 = layoutParams3.f14433dR;
                                                    childCount = layoutParams3.f14435dT;
                                                    f = layoutParams3.f14439dX;
                                                    if (i5 == -1 && i6 == -1) {
                                                        if (layoutParams3.f14430dO != -1) {
                                                            i5 = layoutParams3.f14430dO;
                                                        } else if (layoutParams3.f14429dN != -1) {
                                                            i6 = layoutParams3.f14429dN;
                                                        }
                                                    }
                                                    if (i7 == -1 && size3 == -1) {
                                                        if (layoutParams3.f14431dP != -1) {
                                                            f2 = f;
                                                            mode3 = childCount;
                                                            mode4 = size3;
                                                            i9 = layoutParams3.f14431dP;
                                                        } else if (layoutParams3.f14432dQ != -1) {
                                                            f2 = f;
                                                            mode3 = childCount;
                                                            mode4 = layoutParams3.f14432dQ;
                                                            i9 = i7;
                                                        }
                                                        C17368f p;
                                                        if (layoutParams3.f14426dK == -1) {
                                                            p = m72364p(layoutParams3.f14426dK);
                                                            if (p != null) {
                                                                float f4 = layoutParams3.f14428dM;
                                                                b.mo31446a(C25287c.CENTER, p, C25287c.CENTER, layoutParams3.f14427dL, 0);
                                                                b.f3655it = f4;
                                                            }
                                                        } else {
                                                            if (i5 != -1) {
                                                                p = m72364p(i5);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.LEFT, p, C25287c.LEFT, layoutParams3.leftMargin, i8);
                                                                }
                                                            } else if (i6 != -1) {
                                                                p = m72364p(i6);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.LEFT, p, C25287c.RIGHT, layoutParams3.leftMargin, i8);
                                                                }
                                                            }
                                                            if (i9 != -1) {
                                                                p = m72364p(i9);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.RIGHT, p, C25287c.LEFT, layoutParams3.rightMargin, mode3);
                                                                }
                                                            } else if (mode4 != -1) {
                                                                p = m72364p(mode4);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.RIGHT, p, C25287c.RIGHT, layoutParams3.rightMargin, mode3);
                                                                }
                                                            }
                                                            if (layoutParams3.f14421dF != -1) {
                                                                p = m72364p(layoutParams3.f14421dF);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.TOP, p, C25287c.TOP, layoutParams3.topMargin, layoutParams3.f14434dS);
                                                                }
                                                            } else if (layoutParams3.f14422dG != -1) {
                                                                p = m72364p(layoutParams3.f14422dG);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.TOP, p, C25287c.BOTTOM, layoutParams3.topMargin, layoutParams3.f14434dS);
                                                                }
                                                            }
                                                            if (layoutParams3.f14423dH != -1) {
                                                                p = m72364p(layoutParams3.f14423dH);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.BOTTOM, p, C25287c.TOP, layoutParams3.bottomMargin, layoutParams3.f14436dU);
                                                                }
                                                            } else if (layoutParams3.f14424dI != -1) {
                                                                p = m72364p(layoutParams3.f14424dI);
                                                                if (p != null) {
                                                                    b.mo31446a(C25287c.BOTTOM, p, C25287c.BOTTOM, layoutParams3.bottomMargin, layoutParams3.f14436dU);
                                                                }
                                                            }
                                                            if (layoutParams3.f14425dJ != -1) {
                                                                view = (View) this.f16606db.get(layoutParams3.f14425dJ);
                                                                p = m72364p(layoutParams3.f14425dJ);
                                                                if (!(p == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                                                    layoutParams = (LayoutParams) view.getLayoutParams();
                                                                    layoutParams3.f14471et = true;
                                                                    layoutParams.f14471et = true;
                                                                    b.mo31445a(C25287c.BASELINE).mo42136a(p.mo31445a(C25287c.BASELINE), 0, -1, C25285b.STRONG, 0, true);
                                                                    b.mo31445a(C25287c.TOP).reset();
                                                                    b.mo31445a(C25287c.BOTTOM).reset();
                                                                }
                                                            }
                                                            if (f2 >= 0.0f && f2 != 0.5f) {
                                                                b.f3634iV = f2;
                                                            }
                                                            if (layoutParams3.f14440dY >= 0.0f && layoutParams3.f14440dY != 0.5f) {
                                                                b.f3635iW = layoutParams3.f14440dY;
                                                            }
                                                        }
                                                        if (isInEditMode && !(layoutParams3.f14465em == -1 && layoutParams3.f14466eo == -1)) {
                                                            b.mo31473f(layoutParams3.f14465em, layoutParams3.f14466eo);
                                                        }
                                                        if (!layoutParams3.f14469er) {
                                                            b.mo31447a(C17370a.FIXED);
                                                            b.setWidth(layoutParams3.width);
                                                        } else if (layoutParams3.width == -1) {
                                                            b.mo31447a(C17370a.MATCH_PARENT);
                                                            b.mo31445a(C25287c.LEFT).f5033hz = layoutParams3.leftMargin;
                                                            b.mo31445a(C25287c.RIGHT).f5033hz = layoutParams3.rightMargin;
                                                        } else {
                                                            b.mo31447a(C17370a.MATCH_CONSTRAINT);
                                                            b.setWidth(0);
                                                        }
                                                        if (!layoutParams3.f14470es) {
                                                            b.mo31470b(C17370a.FIXED);
                                                            b.setHeight(layoutParams3.height);
                                                        } else if (layoutParams3.height == -1) {
                                                            b.mo31470b(C17370a.MATCH_PARENT);
                                                            b.mo31445a(C25287c.TOP).f5033hz = layoutParams3.topMargin;
                                                            b.mo31445a(C25287c.BOTTOM).f5033hz = layoutParams3.bottomMargin;
                                                        } else {
                                                            b.mo31470b(C17370a.MATCH_CONSTRAINT);
                                                            b.setHeight(0);
                                                        }
                                                        if (layoutParams3.f14441dZ != null) {
                                                            b.mo31444B(layoutParams3.f14441dZ);
                                                        }
                                                        b.f3671jk[0] = layoutParams3.horizontalWeight;
                                                        b.f3671jk[1] = layoutParams3.verticalWeight;
                                                        b.f3667jg = layoutParams3.f14455ec;
                                                        b.f3668jh = layoutParams3.f14456ed;
                                                        i3 = layoutParams3.f14457ee;
                                                        childCount = layoutParams3.f14459eg;
                                                        size3 = layoutParams3.f14461ei;
                                                        f3 = layoutParams3.f14463ek;
                                                        b.f3640ib = i3;
                                                        b.f3643if = childCount;
                                                        b.f3644ig = size3;
                                                        b.f3645ih = f3;
                                                        if (f3 < 1.0f && b.f3640ib == 0) {
                                                            b.f3640ib = 2;
                                                        }
                                                        i3 = layoutParams3.f14458ef;
                                                        childCount = layoutParams3.f14460eh;
                                                        size3 = layoutParams3.f14462ej;
                                                        f3 = layoutParams3.f14464el;
                                                        b.f3641ic = i3;
                                                        b.f3646ii = childCount;
                                                        b.f3647ij = size3;
                                                        b.f3648ik = f3;
                                                        if (f3 < 1.0f && b.f3641ic == 0) {
                                                            b.f3641ic = 2;
                                                        }
                                                    }
                                                }
                                                f2 = f;
                                                mode3 = childCount;
                                                mode4 = size3;
                                                i9 = i7;
                                                if (layoutParams3.f14426dK == -1) {
                                                }
                                                b.mo31473f(layoutParams3.f14465em, layoutParams3.f14466eo);
                                                if (!layoutParams3.f14469er) {
                                                }
                                                if (!layoutParams3.f14470es) {
                                                }
                                                if (layoutParams3.f14441dZ != null) {
                                                }
                                                b.f3671jk[0] = layoutParams3.horizontalWeight;
                                                b.f3671jk[1] = layoutParams3.verticalWeight;
                                                b.f3667jg = layoutParams3.f14455ec;
                                                b.f3668jh = layoutParams3.f14456ed;
                                                i3 = layoutParams3.f14457ee;
                                                childCount = layoutParams3.f14459eg;
                                                size3 = layoutParams3.f14461ei;
                                                f3 = layoutParams3.f14463ek;
                                                b.f3640ib = i3;
                                                b.f3643if = childCount;
                                                b.f3644ig = size3;
                                                b.f3645ih = f3;
                                                b.f3640ib = 2;
                                                i3 = layoutParams3.f14458ef;
                                                childCount = layoutParams3.f14460eh;
                                                size3 = layoutParams3.f14462ej;
                                                f3 = layoutParams3.f14464el;
                                                b.f3641ic = i3;
                                                b.f3646ii = childCount;
                                                b.f3647ij = size3;
                                                b.f3648ik = f3;
                                                b.f3641ic = 2;
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
        if ((this.f16615dl & 8) == 8) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        Object obj8;
        C41477f c41477f;
        boolean z2;
        if (obj2 != null) {
            C31242g c31242g2 = this.f16609de;
            c31242g2.mo51197bb();
            c31242g2.mo31492u(c31242g2.f14370dl);
            this.f16609de.mo51198j(width, height);
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
                        C17368f c17368f = layoutParams2.f14451eH;
                        if (!(layoutParams2.f14472eu || layoutParams2.f14473ev)) {
                            c17368f.f3638iZ = childAt3.getVisibility();
                            i7 = layoutParams2.width;
                            paddingTop2 = layoutParams2.height;
                            if (i7 == 0 || paddingTop2 == 0) {
                                c17368f.mo31457aM().invalidate();
                                c17368f.mo31458aN().invalidate();
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
                                if (this.f16625dv != null) {
                                    C41477f c41477f2 = this.f16625dv;
                                    c41477f2.f16656gd++;
                                }
                                if (i7 == -2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                c17368f.f3649il = z3;
                                if (paddingTop2 == -2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                c17368f.f3650im = z3;
                                i7 = childAt3.getMeasuredWidth();
                                paddingTop2 = childAt3.getMeasuredHeight();
                                c17368f.setWidth(i7);
                                c17368f.setHeight(paddingTop2);
                                if (obj8 != null) {
                                    c17368f.f3632iS = i7;
                                }
                                if (obj3 != null) {
                                    c17368f.f3633iT = paddingTop2;
                                }
                                if (layoutParams2.f14471et) {
                                    i3 = childAt3.getBaseline();
                                    if (i3 != -1) {
                                        c17368f.f3631iR = i3;
                                    }
                                }
                                if (layoutParams2.f14469er && layoutParams2.f14470es) {
                                    c17368f.mo31457aM().mo31500E(i7);
                                    c17368f.mo31458aN().mo31500E(paddingTop2);
                                }
                            }
                        }
                    }
                    size4 = i8 + 1;
                } else {
                    this.f16609de.mo51196ba();
                    size4 = 0;
                    while (true) {
                        i10 = size4;
                        if (i10 < childCount3) {
                            View childAt4 = getChildAt(i10);
                            if (childAt4.getVisibility() != 8) {
                                layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                                C17368f c17368f2 = layoutParams2.f14451eH;
                                if (!(layoutParams2.f14472eu || layoutParams2.f14473ev)) {
                                    c17368f2.f3638iZ = childAt4.getVisibility();
                                    i8 = layoutParams2.width;
                                    mode4 = layoutParams2.height;
                                    if (i8 == 0 || mode4 == 0) {
                                        C41476m c41476m;
                                        C41476m c41476m2;
                                        Object obj9;
                                        Object obj10;
                                        Object obj11;
                                        C41476m c41476m3 = c17368f2.mo31445a(C25287c.LEFT).f5029hv;
                                        C41476m c41476m4 = c17368f2.mo31445a(C25287c.RIGHT).f5029hv;
                                        if (c17368f2.mo31445a(C25287c.LEFT).f5032hy != null) {
                                            if (c17368f2.mo31445a(C25287c.RIGHT).f5032hy != null) {
                                                obj8 = 1;
                                                c41476m = c17368f2.mo31445a(C25287c.TOP).f5029hv;
                                                c41476m2 = c17368f2.mo31445a(C25287c.BOTTOM).f5029hv;
                                                if (c17368f2.mo31445a(C25287c.TOP).f5032hy != null) {
                                                    if (c17368f2.mo31445a(C25287c.BOTTOM).f5032hy != null) {
                                                        obj9 = 1;
                                                        if (i8 == 0 || mode4 != 0 || r3 == null || obj9 == null) {
                                                            obj4 = null;
                                                            obj3 = this.f16609de.mo31467aW() != C17370a.WRAP_CONTENT ? 1 : null;
                                                            obj5 = this.f16609de.mo31468aX() != C17370a.WRAP_CONTENT ? 1 : null;
                                                            if (obj3 == null) {
                                                                c17368f2.mo31457aM().invalidate();
                                                            }
                                                            if (obj5 == null) {
                                                                c17368f2.mo31458aN().invalidate();
                                                            }
                                                            if (i8 == 0) {
                                                                if (obj3 != null && c17368f2.mo31453aI() && r3 != null && c41476m3.mo42145bg() && c41476m4.mo42145bg()) {
                                                                    i8 = (int) (c41476m4.f16642km - c41476m3.f16642km);
                                                                    c17368f2.mo31457aM().mo31500E(i8);
                                                                    obj8 = null;
                                                                } else {
                                                                    obj10 = null;
                                                                    i9 = 1;
                                                                    i6 = getChildMeasureSpec(i, paddingLeft3, -2);
                                                                    i5 = i8;
                                                                    if (mode4 == 0) {
                                                                        if (obj5 != null && c17368f2.mo31454aJ() && obj9 != null && c41476m.mo42145bg() && c41476m2.mo42145bg()) {
                                                                            size3 = (int) (c41476m2.f16642km - c41476m.f16642km);
                                                                            c17368f2.mo31458aN().mo31500E(size3);
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj4 = 1;
                                                                            obj6 = null;
                                                                            i8 = getChildMeasureSpec(i2, paddingTop3, -2);
                                                                            childAt4.measure(i6, i8);
                                                                            if (this.f16625dv != null) {
                                                                                c41477f = this.f16625dv;
                                                                                c41477f.f16656gd++;
                                                                            }
                                                                            if (i5 == -2) {
                                                                                z2 = true;
                                                                            } else {
                                                                                z2 = false;
                                                                            }
                                                                            c17368f2.f3649il = z2;
                                                                            if (mode4 == -2) {
                                                                                z2 = true;
                                                                            } else {
                                                                                z2 = false;
                                                                            }
                                                                            c17368f2.f3650im = z2;
                                                                            i3 = childAt4.getMeasuredWidth();
                                                                            size3 = childAt4.getMeasuredHeight();
                                                                            c17368f2.setWidth(i3);
                                                                            c17368f2.setHeight(size3);
                                                                            if (obj11 != null) {
                                                                                c17368f2.f3632iS = i3;
                                                                            }
                                                                            if (obj4 != null) {
                                                                                c17368f2.f3633iT = size3;
                                                                            }
                                                                            if (obj10 != null) {
                                                                                c17368f2.mo31457aM().mo31500E(i3);
                                                                            } else {
                                                                                c17368f2.mo31457aM().state = 2;
                                                                            }
                                                                            if (obj6 != null) {
                                                                                c17368f2.mo31458aN().mo31500E(size3);
                                                                            } else {
                                                                                c17368f2.mo31458aN().state = 2;
                                                                            }
                                                                            if (layoutParams2.f14471et) {
                                                                                size4 = childAt4.getBaseline();
                                                                                if (size4 != -1) {
                                                                                    c17368f2.f3631iR = size4;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (mode4 == -1) {
                                                                        obj6 = obj5;
                                                                        i8 = getChildMeasureSpec(i2, paddingTop3, -1);
                                                                        childAt4.measure(i6, i8);
                                                                        if (this.f16625dv != null) {
                                                                        }
                                                                        if (i5 == -2) {
                                                                        }
                                                                        c17368f2.f3649il = z2;
                                                                        if (mode4 == -2) {
                                                                        }
                                                                        c17368f2.f3650im = z2;
                                                                        i3 = childAt4.getMeasuredWidth();
                                                                        size3 = childAt4.getMeasuredHeight();
                                                                        c17368f2.setWidth(i3);
                                                                        c17368f2.setHeight(size3);
                                                                        if (obj11 != null) {
                                                                        }
                                                                        if (obj4 != null) {
                                                                        }
                                                                        if (obj10 != null) {
                                                                        }
                                                                        if (obj6 != null) {
                                                                        }
                                                                        if (layoutParams2.f14471et) {
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
                                                                    if (this.f16625dv != null) {
                                                                    }
                                                                    if (i5 == -2) {
                                                                    }
                                                                    c17368f2.f3649il = z2;
                                                                    if (mode4 == -2) {
                                                                    }
                                                                    c17368f2.f3650im = z2;
                                                                    i3 = childAt4.getMeasuredWidth();
                                                                    size3 = childAt4.getMeasuredHeight();
                                                                    c17368f2.setWidth(i3);
                                                                    c17368f2.setHeight(size3);
                                                                    if (obj11 != null) {
                                                                    }
                                                                    if (obj4 != null) {
                                                                    }
                                                                    if (obj10 != null) {
                                                                    }
                                                                    if (obj6 != null) {
                                                                    }
                                                                    if (layoutParams2.f14471et) {
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
                                                                if (this.f16625dv != null) {
                                                                }
                                                                if (i5 == -2) {
                                                                }
                                                                c17368f2.f3649il = z2;
                                                                if (mode4 == -2) {
                                                                }
                                                                c17368f2.f3650im = z2;
                                                                i3 = childAt4.getMeasuredWidth();
                                                                size3 = childAt4.getMeasuredHeight();
                                                                c17368f2.setWidth(i3);
                                                                c17368f2.setHeight(size3);
                                                                if (obj11 != null) {
                                                                }
                                                                if (obj4 != null) {
                                                                }
                                                                if (obj10 != null) {
                                                                }
                                                                if (obj6 != null) {
                                                                }
                                                                if (layoutParams2.f14471et) {
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
                                                            if (this.f16625dv != null) {
                                                            }
                                                            if (i5 == -2) {
                                                            }
                                                            c17368f2.f3649il = z2;
                                                            if (mode4 == -2) {
                                                            }
                                                            c17368f2.f3650im = z2;
                                                            i3 = childAt4.getMeasuredWidth();
                                                            size3 = childAt4.getMeasuredHeight();
                                                            c17368f2.setWidth(i3);
                                                            c17368f2.setHeight(size3);
                                                            if (obj11 != null) {
                                                            }
                                                            if (obj4 != null) {
                                                            }
                                                            if (obj10 != null) {
                                                            }
                                                            if (obj6 != null) {
                                                            }
                                                            if (layoutParams2.f14471et) {
                                                            }
                                                        }
                                                    }
                                                }
                                                obj9 = null;
                                                if (i8 == 0) {
                                                }
                                                obj4 = null;
                                                if (this.f16609de.mo31467aW() != C17370a.WRAP_CONTENT) {
                                                }
                                                if (this.f16609de.mo31468aX() != C17370a.WRAP_CONTENT) {
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
                                                if (this.f16625dv != null) {
                                                }
                                                if (i5 == -2) {
                                                }
                                                c17368f2.f3649il = z2;
                                                if (mode4 == -2) {
                                                }
                                                c17368f2.f3650im = z2;
                                                i3 = childAt4.getMeasuredWidth();
                                                size3 = childAt4.getMeasuredHeight();
                                                c17368f2.setWidth(i3);
                                                c17368f2.setHeight(size3);
                                                if (obj11 != null) {
                                                }
                                                if (obj4 != null) {
                                                }
                                                if (obj10 != null) {
                                                }
                                                if (obj6 != null) {
                                                }
                                                if (layoutParams2.f14471et) {
                                                }
                                            }
                                        }
                                        obj8 = null;
                                        c41476m = c17368f2.mo31445a(C25287c.TOP).f5029hv;
                                        c41476m2 = c17368f2.mo31445a(C25287c.BOTTOM).f5029hv;
                                        if (c17368f2.mo31445a(C25287c.TOP).f5032hy != null) {
                                        }
                                        obj9 = null;
                                        if (i8 == 0) {
                                        }
                                        obj4 = null;
                                        if (this.f16609de.mo31467aW() != C17370a.WRAP_CONTENT) {
                                        }
                                        if (this.f16609de.mo31468aX() != C17370a.WRAP_CONTENT) {
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
                                        if (this.f16625dv != null) {
                                        }
                                        if (i5 == -2) {
                                        }
                                        c17368f2.f3649il = z2;
                                        if (mode4 == -2) {
                                        }
                                        c17368f2.f3650im = z2;
                                        i3 = childAt4.getMeasuredWidth();
                                        size3 = childAt4.getMeasuredHeight();
                                        c17368f2.setWidth(i3);
                                        c17368f2.setHeight(size3);
                                        if (obj11 != null) {
                                        }
                                        if (obj4 != null) {
                                        }
                                        if (obj10 != null) {
                                        }
                                        if (obj6 != null) {
                                        }
                                        if (layoutParams2.f14471et) {
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
                    C17368f c17368f3 = layoutParams2.f14451eH;
                    if (!(layoutParams2.f14472eu || layoutParams2.f14473ev)) {
                        Object obj12;
                        c17368f3.f3638iZ = childAt5.getVisibility();
                        paddingTop2 = layoutParams2.width;
                        mode4 = layoutParams2.height;
                        if (layoutParams2.f14469er || layoutParams2.f14470es || ((!layoutParams2.f14469er && layoutParams2.f14457ee == 1) || layoutParams2.width == -1 || (!layoutParams2.f14470es && (layoutParams2.f14458ef == 1 || layoutParams2.height == -1)))) {
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
                            if (this.f16625dv != null) {
                                c41477f = this.f16625dv;
                                c41477f.f16656gd++;
                            }
                            if (paddingTop2 == -2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            c17368f3.f3649il = z2;
                            if (mode4 == -2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            c17368f3.f3650im = z2;
                            mode4 = childAt5.getMeasuredWidth();
                            obj8 = obj4;
                            i7 = childAt5.getMeasuredHeight();
                            paddingTop2 = mode4;
                        } else {
                            obj12 = null;
                            i7 = mode4;
                        }
                        c17368f3.setWidth(paddingTop2);
                        c17368f3.setHeight(i7);
                        if (obj8 != null) {
                            c17368f3.f3632iS = paddingTop2;
                        }
                        if (obj12 != null) {
                            c17368f3.f3633iT = i7;
                        }
                        if (layoutParams2.f14471et) {
                            size4 = childAt5.getBaseline();
                            if (size4 != -1) {
                                c17368f3.f3631iR = size4;
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
                if (placeholder2.f15634fs != null) {
                    layoutParams = (LayoutParams) placeholder2.getLayoutParams();
                    layoutParams2 = (LayoutParams) placeholder2.f15634fs.getLayoutParams();
                    layoutParams2.f14451eH.f3638iZ = 0;
                    layoutParams.f14451eH.setWidth(layoutParams2.f14451eH.getWidth());
                    layoutParams.f14451eH.setHeight(layoutParams2.f14451eH.getHeight());
                    layoutParams2.f14451eH.f3638iZ = 8;
                }
            }
        }
        i3 = this.f16607dc.size();
        if (i3 > 0) {
            for (size4 = 0; size4 < i3; size4++) {
                this.f16607dc.get(size4);
            }
        }
        if (getChildCount() > 0 && obj7 != null) {
            C41470a.m72373a(this.f16609de);
        }
        if (this.f16609de.f14378jG) {
            if (this.f16609de.f14379jH && mode == Integer.MIN_VALUE) {
                if (this.f16609de.f14381jJ < size) {
                    this.f16609de.setWidth(this.f16609de.f14381jJ);
                }
                this.f16609de.mo31447a(C17370a.FIXED);
            }
            if (this.f16609de.f14380jI && mode2 == Integer.MIN_VALUE) {
                if (this.f16609de.f14382jK < size2) {
                    this.f16609de.setHeight(this.f16609de.f14382jK);
                }
                this.f16609de.mo31470b(C17370a.FIXED);
            }
        }
        if ((this.f16615dl & 32) == 32) {
            size4 = this.f16609de.getWidth();
            i3 = this.f16609de.getHeight();
            if (this.f16619dp != size4 && mode == 1073741824) {
                C41470a.m72375a(this.f16609de.f14377jF, 0, size4);
            }
            if (this.f16620dq != i3 && mode2 == 1073741824) {
                C41470a.m72375a(this.f16609de.f14377jF, 1, i3);
            }
            if (this.f16609de.f14379jH && this.f16609de.f14381jJ > size) {
                C41470a.m72375a(this.f16609de.f14377jF, 0, size);
            }
            if (this.f16609de.f14380jI && this.f16609de.f14382jK > size2) {
                C41470a.m72375a(this.f16609de.f14377jF, 1, size2);
            }
        }
        if (getChildCount() > 0) {
            m72360ar();
        }
        i9 = 0;
        i5 = this.f16608dd.size();
        i4 = paddingTop + getPaddingBottom();
        i10 = paddingLeft + getPaddingRight();
        if (i5 > 0) {
            obj5 = null;
            obj3 = this.f16609de.mo31467aW() == C17370a.WRAP_CONTENT ? 1 : null;
            if (this.f16609de.mo31468aX() == C17370a.WRAP_CONTENT) {
                obj6 = 1;
            } else {
                obj6 = null;
            }
            mode4 = Math.max(this.f16609de.getWidth(), this.f16610dg);
            paddingLeft2 = Math.max(this.f16609de.getHeight(), this.f16611dh);
            i6 = 0;
            while (i6 < i5) {
                b = (C17368f) this.f16608dd.get(i6);
                view = (View) b.f3636iX;
                if (view != null) {
                    LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
                    if (!(layoutParams4.f14473ev || layoutParams4.f14472eu || view.getVisibility() == 8 || (obj2 != null && b.mo31457aM().mo42145bg() && b.mo31458aN().mo42145bg()))) {
                        Object obj13;
                        if (layoutParams4.width == -2 && layoutParams4.f14469er) {
                            i8 = getChildMeasureSpec(i, i10, layoutParams4.width);
                        } else {
                            i8 = MeasureSpec.makeMeasureSpec(b.getWidth(), ErrorDialogData.SUPPRESSED);
                        }
                        if (layoutParams4.height == -2 && layoutParams4.f14470es) {
                            mode3 = getChildMeasureSpec(i2, i4, layoutParams4.height);
                        } else {
                            mode3 = MeasureSpec.makeMeasureSpec(b.getHeight(), ErrorDialogData.SUPPRESSED);
                        }
                        view.measure(i8, mode3);
                        if (this.f16625dv != null) {
                            C41477f c41477f3 = this.f16625dv;
                            c41477f3.f16657ge++;
                        }
                        i8 = view.getMeasuredWidth();
                        mode = view.getMeasuredHeight();
                        if (i8 != b.getWidth()) {
                            b.setWidth(i8);
                            if (obj2 != null) {
                                b.mo31457aM().mo31500E(i8);
                            }
                            if (obj3 == null || b.getRight() <= mode4) {
                                i8 = mode4;
                            } else {
                                i8 = Math.max(mode4, b.getRight() + b.mo31445a(C25287c.RIGHT).mo42138aH());
                            }
                            obj4 = 1;
                        } else {
                            i8 = mode4;
                            obj4 = obj5;
                        }
                        if (mode != b.getHeight()) {
                            b.setHeight(mode);
                            if (obj2 != null) {
                                b.mo31458aN().mo31500E(mode);
                            }
                            if (obj6 == null || b.getBottom() <= paddingLeft2) {
                                mode3 = paddingLeft2;
                            } else {
                                mode3 = Math.max(paddingLeft2, b.getBottom() + b.mo31445a(C25287c.BOTTOM).mo42138aH());
                            }
                            obj13 = 1;
                            paddingLeft2 = mode3;
                        } else {
                            obj13 = obj4;
                        }
                        if (layoutParams4.f14471et) {
                            childCount = view.getBaseline();
                            if (!(childCount == -1 || childCount == b.f3631iR)) {
                                b.f3631iR = childCount;
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
                this.f16609de.setWidth(width);
                this.f16609de.setHeight(height);
                if (obj2 != null) {
                    this.f16609de.mo51196ba();
                }
                m72360ar();
                obj = null;
                if (this.f16609de.getWidth() < mode4) {
                    this.f16609de.setWidth(mode4);
                    obj = 1;
                }
                if (this.f16609de.getHeight() < paddingLeft2) {
                    this.f16609de.setHeight(paddingLeft2);
                    obj = 1;
                }
                if (obj != null) {
                    m72360ar();
                }
            }
            for (childCount = 0; childCount < i5; childCount++) {
                b = (C17368f) this.f16608dd.get(childCount);
                view = (View) b.f3636iX;
                if (!(view == null || ((view.getMeasuredWidth() == b.getWidth() && view.getMeasuredHeight() == b.getHeight()) || b.f3638iZ == 8))) {
                    view.measure(MeasureSpec.makeMeasureSpec(b.getWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(b.getHeight(), ErrorDialogData.SUPPRESSED));
                    if (this.f16625dv != null) {
                        C41477f c41477f4 = this.f16625dv;
                        c41477f4.f16657ge++;
                    }
                }
            }
        }
        size4 = this.f16609de.getWidth() + i10;
        i3 = this.f16609de.getHeight() + i4;
        if (VERSION.SDK_INT >= 11) {
            i3 = resolveSizeAndState(i3, i2, i9 << 16) & 16777215;
            size4 = Math.min(this.f16612di, resolveSizeAndState(size4, i, i9) & 16777215);
            i3 = Math.min(this.f16613dj, i3);
            if (this.f16609de.f14384jM) {
                size4 |= 16777216;
            }
            if (this.f16609de.f14385jN) {
                i3 |= 16777216;
            }
            setMeasuredDimension(size4, i3);
            this.f16619dp = size4;
            this.f16620dq = i3;
            return;
        }
        setMeasuredDimension(size4, i3);
        this.f16619dp = size4;
        this.f16620dq = i3;
    }

    /* renamed from: ar */
    private void m72360ar() {
        this.f16609de.mo42147aZ();
        if (this.f16625dv != null) {
            C41477f c41477f = this.f16625dv;
            c41477f.f16658gf++;
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
            C17368f c17368f = layoutParams.f14451eH;
            if ((childAt.getVisibility() != 8 || layoutParams.f14472eu || layoutParams.f14473ev || isInEditMode) && !layoutParams.f14474ew) {
                aO = c17368f.mo31459aO();
                int aP = c17368f.mo31460aP();
                int width = c17368f.getWidth() + aO;
                int height = c17368f.getHeight() + aP;
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
        i5 = this.f16607dc.size();
        if (i5 > 0) {
            for (aO = 0; aO < i5; aO++) {
                ((ConstraintHelper) this.f16607dc.get(aO)).mo51785aq();
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f16609de.f14370dl = i;
    }

    public int getOptimizationLevel() {
        return this.f16609de.f14370dl;
    }

    /* renamed from: as */
    protected static LayoutParams m72361as() {
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

    public void setConstraintSet(C37095a c37095a) {
        this.f16616dm = c37095a;
    }

    /* renamed from: q */
    public final View mo66130q(int i) {
        return (View) this.f16606db.get(i);
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
        this.f16614dk = true;
        this.f16619dp = -1;
        this.f16620dq = -1;
        this.f16621dr = -1;
        this.f16622ds = -1;
        this.f16623dt = 0;
        this.f16624du = 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
