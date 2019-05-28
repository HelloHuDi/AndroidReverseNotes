package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.R.id;
import android.util.SparseIntArray;
import android.view.View;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: android.support.constraint.a */
public final class C37095a {
    /* renamed from: eK */
    private static final int[] f15655eK = new int[]{0, 4, 8};
    /* renamed from: eM */
    private static SparseIntArray f15656eM;
    /* renamed from: eL */
    HashMap<Integer, C31827a> f15657eL = new HashMap();

    /* renamed from: android.support.constraint.a$a */
    static class C31827a {
        public float alpha;
        public int bottomMargin;
        /* renamed from: dA */
        public float f14478dA;
        /* renamed from: dB */
        public int f14479dB;
        /* renamed from: dC */
        public int f14480dC;
        /* renamed from: dD */
        public int f14481dD;
        /* renamed from: dE */
        public int f14482dE;
        /* renamed from: dF */
        public int f14483dF;
        /* renamed from: dG */
        public int f14484dG;
        /* renamed from: dH */
        public int f14485dH;
        /* renamed from: dI */
        public int f14486dI;
        /* renamed from: dJ */
        public int f14487dJ;
        /* renamed from: dK */
        public int f14488dK;
        /* renamed from: dL */
        public int f14489dL;
        /* renamed from: dM */
        public float f14490dM;
        /* renamed from: dN */
        public int f14491dN;
        /* renamed from: dO */
        public int f14492dO;
        /* renamed from: dP */
        public int f14493dP;
        /* renamed from: dQ */
        public int f14494dQ;
        /* renamed from: dR */
        public int f14495dR;
        /* renamed from: dS */
        public int f14496dS;
        /* renamed from: dT */
        public int f14497dT;
        /* renamed from: dU */
        public int f14498dU;
        /* renamed from: dV */
        public int f14499dV;
        /* renamed from: dW */
        public int f14500dW;
        /* renamed from: dX */
        public float f14501dX;
        /* renamed from: dY */
        public float f14502dY;
        /* renamed from: dZ */
        public String f14503dZ;
        /* renamed from: dw */
        public int f14504dw;
        /* renamed from: dz */
        public int f14505dz;
        /* renamed from: eN */
        boolean f14506eN;
        /* renamed from: eO */
        int f14507eO;
        /* renamed from: eP */
        public int f14508eP;
        /* renamed from: eQ */
        public int f14509eQ;
        /* renamed from: eR */
        public boolean f14510eR;
        /* renamed from: eS */
        public float f14511eS;
        /* renamed from: eT */
        public float f14512eT;
        /* renamed from: eU */
        public float f14513eU;
        /* renamed from: eV */
        public float f14514eV;
        /* renamed from: eW */
        public float f14515eW;
        /* renamed from: eX */
        public float f14516eX;
        /* renamed from: eY */
        public float f14517eY;
        /* renamed from: eZ */
        public float f14518eZ;
        /* renamed from: ec */
        public int f14519ec;
        /* renamed from: ed */
        public int f14520ed;
        /* renamed from: em */
        public int f14521em;
        /* renamed from: eo */
        public int f14522eo;
        /* renamed from: ep */
        public boolean f14523ep;
        /* renamed from: eq */
        public boolean f14524eq;
        /* renamed from: fa */
        public int f14525fa;
        /* renamed from: fb */
        public int f14526fb;
        /* renamed from: fc */
        public int f14527fc;
        /* renamed from: fe */
        public int f14528fe;
        /* renamed from: ff */
        public int f14529ff;
        /* renamed from: fg */
        public int f14530fg;
        /* renamed from: fh */
        public float f14531fh;
        /* renamed from: fi */
        public float f14532fi;
        /* renamed from: fj */
        public boolean f14533fj;
        /* renamed from: fk */
        public int f14534fk;
        /* renamed from: fl */
        public int f14535fl;
        /* renamed from: fn */
        public int[] f14536fn;
        /* renamed from: fo */
        public String f14537fo;
        public float horizontalWeight;
        public int leftMargin;
        public int mHeight;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public float rotation;
        public float scaleX;
        public float scaleY;
        public int topMargin;
        public float verticalWeight;
        public int visibility;

        private C31827a() {
            this.f14506eN = false;
            this.f14504dw = -1;
            this.f14505dz = -1;
            this.f14478dA = -1.0f;
            this.f14479dB = -1;
            this.f14480dC = -1;
            this.f14481dD = -1;
            this.f14482dE = -1;
            this.f14483dF = -1;
            this.f14484dG = -1;
            this.f14485dH = -1;
            this.f14486dI = -1;
            this.f14487dJ = -1;
            this.f14491dN = -1;
            this.f14492dO = -1;
            this.f14493dP = -1;
            this.f14494dQ = -1;
            this.f14501dX = 0.5f;
            this.f14502dY = 0.5f;
            this.f14503dZ = null;
            this.f14488dK = -1;
            this.f14489dL = 0;
            this.f14490dM = 0.0f;
            this.f14521em = -1;
            this.f14522eo = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.f14508eP = -1;
            this.f14509eQ = -1;
            this.visibility = 0;
            this.f14495dR = -1;
            this.f14496dS = -1;
            this.f14497dT = -1;
            this.f14498dU = -1;
            this.f14500dW = -1;
            this.f14499dV = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.f14519ec = 0;
            this.f14520ed = 0;
            this.alpha = 1.0f;
            this.f14510eR = false;
            this.f14511eS = 0.0f;
            this.rotation = 0.0f;
            this.f14512eT = 0.0f;
            this.f14513eU = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.f14514eV = Float.NaN;
            this.f14515eW = Float.NaN;
            this.f14516eX = 0.0f;
            this.f14517eY = 0.0f;
            this.f14518eZ = 0.0f;
            this.f14523ep = false;
            this.f14524eq = false;
            this.f14525fa = 0;
            this.f14526fb = 0;
            this.f14527fc = -1;
            this.f14528fe = -1;
            this.f14529ff = -1;
            this.f14530fg = -1;
            this.f14531fh = 1.0f;
            this.f14532fi = 1.0f;
            this.f14533fj = false;
            this.f14534fk = -1;
            this.f14535fl = -1;
        }

        /* synthetic */ C31827a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo51787a(LayoutParams layoutParams) {
            layoutParams.f14417dB = this.f14479dB;
            layoutParams.f14418dC = this.f14480dC;
            layoutParams.f14419dD = this.f14481dD;
            layoutParams.f14420dE = this.f14482dE;
            layoutParams.f14421dF = this.f14483dF;
            layoutParams.f14422dG = this.f14484dG;
            layoutParams.f14423dH = this.f14485dH;
            layoutParams.f14424dI = this.f14486dI;
            layoutParams.f14425dJ = this.f14487dJ;
            layoutParams.f14429dN = this.f14491dN;
            layoutParams.f14430dO = this.f14492dO;
            layoutParams.f14431dP = this.f14493dP;
            layoutParams.f14432dQ = this.f14494dQ;
            layoutParams.leftMargin = this.leftMargin;
            layoutParams.rightMargin = this.rightMargin;
            layoutParams.topMargin = this.topMargin;
            layoutParams.bottomMargin = this.bottomMargin;
            layoutParams.f14437dV = this.f14499dV;
            layoutParams.f14438dW = this.f14500dW;
            layoutParams.f14439dX = this.f14501dX;
            layoutParams.f14440dY = this.f14502dY;
            layoutParams.f14426dK = this.f14488dK;
            layoutParams.f14427dL = this.f14489dL;
            layoutParams.f14428dM = this.f14490dM;
            layoutParams.f14441dZ = this.f14503dZ;
            layoutParams.f14465em = this.f14521em;
            layoutParams.f14466eo = this.f14522eo;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.f14456ed = this.f14520ed;
            layoutParams.f14455ec = this.f14519ec;
            layoutParams.f14467ep = this.f14523ep;
            layoutParams.f14468eq = this.f14524eq;
            layoutParams.f14457ee = this.f14525fa;
            layoutParams.f14458ef = this.f14526fb;
            layoutParams.f14461ei = this.f14527fc;
            layoutParams.f14462ej = this.f14528fe;
            layoutParams.f14459eg = this.f14529ff;
            layoutParams.f14460eh = this.f14530fg;
            layoutParams.f14463ek = this.f14531fh;
            layoutParams.f14464el = this.f14532fi;
            layoutParams.orientation = this.orientation;
            layoutParams.f14416dA = this.f14478dA;
            layoutParams.f14442dw = this.f14504dw;
            layoutParams.f14443dz = this.f14505dz;
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mHeight;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f14509eQ);
                layoutParams.setMarginEnd(this.f14508eP);
            }
            layoutParams.validate();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo51786a(int i, Constraints.LayoutParams layoutParams) {
            this.f14507eO = i;
            this.f14479dB = layoutParams.f14417dB;
            this.f14480dC = layoutParams.f14418dC;
            this.f14481dD = layoutParams.f14419dD;
            this.f14482dE = layoutParams.f14420dE;
            this.f14483dF = layoutParams.f14421dF;
            this.f14484dG = layoutParams.f14422dG;
            this.f14485dH = layoutParams.f14423dH;
            this.f14486dI = layoutParams.f14424dI;
            this.f14487dJ = layoutParams.f14425dJ;
            this.f14491dN = layoutParams.f14429dN;
            this.f14492dO = layoutParams.f14430dO;
            this.f14493dP = layoutParams.f14431dP;
            this.f14494dQ = layoutParams.f14432dQ;
            this.f14501dX = layoutParams.f14439dX;
            this.f14502dY = layoutParams.f14440dY;
            this.f14503dZ = layoutParams.f14441dZ;
            this.f14488dK = layoutParams.f14426dK;
            this.f14489dL = layoutParams.f14427dL;
            this.f14490dM = layoutParams.f14428dM;
            this.f14521em = layoutParams.f14465em;
            this.f14522eo = layoutParams.f14466eo;
            this.orientation = layoutParams.orientation;
            this.f14478dA = layoutParams.f14416dA;
            this.f14504dw = layoutParams.f14442dw;
            this.f14505dz = layoutParams.f14443dz;
            this.mWidth = layoutParams.width;
            this.mHeight = layoutParams.height;
            this.leftMargin = layoutParams.leftMargin;
            this.rightMargin = layoutParams.rightMargin;
            this.topMargin = layoutParams.topMargin;
            this.bottomMargin = layoutParams.bottomMargin;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.f14520ed = layoutParams.f14456ed;
            this.f14519ec = layoutParams.f14455ec;
            this.f14523ep = layoutParams.f14467ep;
            this.f14524eq = layoutParams.f14468eq;
            this.f14525fa = layoutParams.f14457ee;
            this.f14526fb = layoutParams.f14458ef;
            this.f14523ep = layoutParams.f14467ep;
            this.f14527fc = layoutParams.f14461ei;
            this.f14528fe = layoutParams.f14462ej;
            this.f14529ff = layoutParams.f14459eg;
            this.f14530fg = layoutParams.f14460eh;
            this.f14531fh = layoutParams.f14463ek;
            this.f14532fi = layoutParams.f14464el;
            if (VERSION.SDK_INT >= 17) {
                this.f14508eP = layoutParams.getMarginEnd();
                this.f14509eQ = layoutParams.getMarginStart();
            }
            this.alpha = layoutParams.alpha;
            this.rotation = layoutParams.rotation;
            this.f14512eT = layoutParams.f2145eT;
            this.f14513eU = layoutParams.f2146eU;
            this.scaleX = layoutParams.scaleX;
            this.scaleY = layoutParams.scaleY;
            this.f14514eV = layoutParams.f2147eV;
            this.f14515eW = layoutParams.f2148eW;
            this.f14516eX = layoutParams.f2149eX;
            this.f14517eY = layoutParams.f2150eY;
            this.f14518eZ = layoutParams.f2151eZ;
            this.f14511eS = layoutParams.f2144eS;
            this.f14510eR = layoutParams.f2143eR;
        }

        public final /* synthetic */ Object clone() {
            C31827a c31827a = new C31827a();
            c31827a.f14506eN = this.f14506eN;
            c31827a.mWidth = this.mWidth;
            c31827a.mHeight = this.mHeight;
            c31827a.f14504dw = this.f14504dw;
            c31827a.f14505dz = this.f14505dz;
            c31827a.f14478dA = this.f14478dA;
            c31827a.f14479dB = this.f14479dB;
            c31827a.f14480dC = this.f14480dC;
            c31827a.f14481dD = this.f14481dD;
            c31827a.f14482dE = this.f14482dE;
            c31827a.f14483dF = this.f14483dF;
            c31827a.f14484dG = this.f14484dG;
            c31827a.f14485dH = this.f14485dH;
            c31827a.f14486dI = this.f14486dI;
            c31827a.f14487dJ = this.f14487dJ;
            c31827a.f14491dN = this.f14491dN;
            c31827a.f14492dO = this.f14492dO;
            c31827a.f14493dP = this.f14493dP;
            c31827a.f14494dQ = this.f14494dQ;
            c31827a.f14501dX = this.f14501dX;
            c31827a.f14502dY = this.f14502dY;
            c31827a.f14503dZ = this.f14503dZ;
            c31827a.f14521em = this.f14521em;
            c31827a.f14522eo = this.f14522eo;
            c31827a.f14501dX = this.f14501dX;
            c31827a.f14501dX = this.f14501dX;
            c31827a.f14501dX = this.f14501dX;
            c31827a.f14501dX = this.f14501dX;
            c31827a.f14501dX = this.f14501dX;
            c31827a.orientation = this.orientation;
            c31827a.leftMargin = this.leftMargin;
            c31827a.rightMargin = this.rightMargin;
            c31827a.topMargin = this.topMargin;
            c31827a.bottomMargin = this.bottomMargin;
            c31827a.f14508eP = this.f14508eP;
            c31827a.f14509eQ = this.f14509eQ;
            c31827a.visibility = this.visibility;
            c31827a.f14495dR = this.f14495dR;
            c31827a.f14496dS = this.f14496dS;
            c31827a.f14497dT = this.f14497dT;
            c31827a.f14498dU = this.f14498dU;
            c31827a.f14500dW = this.f14500dW;
            c31827a.f14499dV = this.f14499dV;
            c31827a.verticalWeight = this.verticalWeight;
            c31827a.horizontalWeight = this.horizontalWeight;
            c31827a.f14519ec = this.f14519ec;
            c31827a.f14520ed = this.f14520ed;
            c31827a.alpha = this.alpha;
            c31827a.f14510eR = this.f14510eR;
            c31827a.f14511eS = this.f14511eS;
            c31827a.rotation = this.rotation;
            c31827a.f14512eT = this.f14512eT;
            c31827a.f14513eU = this.f14513eU;
            c31827a.scaleX = this.scaleX;
            c31827a.scaleY = this.scaleY;
            c31827a.f14514eV = this.f14514eV;
            c31827a.f14515eW = this.f14515eW;
            c31827a.f14516eX = this.f14516eX;
            c31827a.f14517eY = this.f14517eY;
            c31827a.f14518eZ = this.f14518eZ;
            c31827a.f14523ep = this.f14523ep;
            c31827a.f14524eq = this.f14524eq;
            c31827a.f14525fa = this.f14525fa;
            c31827a.f14526fb = this.f14526fb;
            c31827a.f14527fc = this.f14527fc;
            c31827a.f14528fe = this.f14528fe;
            c31827a.f14529ff = this.f14529ff;
            c31827a.f14530fg = this.f14530fg;
            c31827a.f14531fh = this.f14531fh;
            c31827a.f14532fi = this.f14532fi;
            c31827a.f14534fk = this.f14534fk;
            c31827a.f14535fl = this.f14535fl;
            if (this.f14536fn != null) {
                c31827a.f14536fn = Arrays.copyOf(this.f14536fn, this.f14536fn.length);
            }
            c31827a.f14488dK = this.f14488dK;
            c31827a.f14489dL = this.f14489dL;
            c31827a.f14490dM = this.f14490dM;
            c31827a.f14533fj = this.f14533fj;
            return c31827a;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15656eM = sparseIntArray;
        sparseIntArray.append(55, 25);
        f15656eM.append(56, 26);
        f15656eM.append(58, 29);
        f15656eM.append(59, 30);
        f15656eM.append(64, 36);
        f15656eM.append(63, 35);
        f15656eM.append(37, 4);
        f15656eM.append(36, 3);
        f15656eM.append(34, 1);
        f15656eM.append(72, 6);
        f15656eM.append(73, 7);
        f15656eM.append(44, 17);
        f15656eM.append(45, 18);
        f15656eM.append(46, 19);
        f15656eM.append(0, 27);
        f15656eM.append(60, 32);
        f15656eM.append(61, 33);
        f15656eM.append(43, 10);
        f15656eM.append(42, 9);
        f15656eM.append(76, 13);
        f15656eM.append(79, 16);
        f15656eM.append(77, 14);
        f15656eM.append(74, 11);
        f15656eM.append(78, 15);
        f15656eM.append(75, 12);
        f15656eM.append(67, 40);
        f15656eM.append(53, 39);
        f15656eM.append(52, 41);
        f15656eM.append(66, 42);
        f15656eM.append(51, 20);
        f15656eM.append(65, 37);
        f15656eM.append(41, 5);
        f15656eM.append(54, 75);
        f15656eM.append(62, 75);
        f15656eM.append(57, 75);
        f15656eM.append(35, 75);
        f15656eM.append(33, 75);
        f15656eM.append(5, 24);
        f15656eM.append(7, 28);
        f15656eM.append(23, 31);
        f15656eM.append(24, 8);
        f15656eM.append(6, 34);
        f15656eM.append(8, 2);
        f15656eM.append(3, 23);
        f15656eM.append(4, 21);
        f15656eM.append(2, 22);
        f15656eM.append(13, 43);
        f15656eM.append(26, 44);
        f15656eM.append(21, 45);
        f15656eM.append(22, 46);
        f15656eM.append(20, 60);
        f15656eM.append(18, 47);
        f15656eM.append(19, 48);
        f15656eM.append(14, 49);
        f15656eM.append(15, 50);
        f15656eM.append(16, 51);
        f15656eM.append(17, 52);
        f15656eM.append(25, 53);
        f15656eM.append(68, 54);
        f15656eM.append(47, 55);
        f15656eM.append(69, 56);
        f15656eM.append(48, 57);
        f15656eM.append(70, 58);
        f15656eM.append(49, 59);
        f15656eM.append(38, 61);
        f15656eM.append(40, 62);
        f15656eM.append(39, 63);
        f15656eM.append(1, 38);
        f15656eM.append(71, 69);
        f15656eM.append(50, 70);
        f15656eM.append(29, 71);
        f15656eM.append(28, 72);
        f15656eM.append(30, 73);
        f15656eM.append(27, 74);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo59120b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f15657eL.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f15657eL.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C31827a c31827a = (C31827a) this.f15657eL.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    c31827a.f14535fl = 1;
                }
                if (c31827a.f14535fl != -1) {
                    switch (c31827a.f14535fl) {
                        case 1:
                            View view = (Barrier) childAt;
                            view.setId(id);
                            view.setType(c31827a.f14534fk);
                            view.setAllowsGoneWidget(c31827a.f14533fj);
                            if (c31827a.f14536fn == null) {
                                if (c31827a.f14537fo != null) {
                                    c31827a.f14536fn = C37095a.m62055a(view, c31827a.f14537fo);
                                    view.setReferencedIds(c31827a.f14536fn);
                                    break;
                                }
                            }
                            view.setReferencedIds(c31827a.f14536fn);
                            break;
                            break;
                    }
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                c31827a.mo51787a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(c31827a.visibility);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(c31827a.alpha);
                    childAt.setRotation(c31827a.rotation);
                    childAt.setRotationX(c31827a.f14512eT);
                    childAt.setRotationY(c31827a.f14513eU);
                    childAt.setScaleX(c31827a.scaleX);
                    childAt.setScaleY(c31827a.scaleY);
                    if (!Float.isNaN(c31827a.f14514eV)) {
                        childAt.setPivotX(c31827a.f14514eV);
                    }
                    if (!Float.isNaN(c31827a.f14515eW)) {
                        childAt.setPivotY(c31827a.f14515eW);
                    }
                    childAt.setTranslationX(c31827a.f14516eX);
                    childAt.setTranslationY(c31827a.f14517eY);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(c31827a.f14518eZ);
                        if (c31827a.f14510eR) {
                            childAt.setElevation(c31827a.f14511eS);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C31827a c31827a2 = (C31827a) this.f15657eL.get(num);
            if (c31827a2.f14535fl != -1) {
                switch (c31827a2.f14535fl) {
                    case 1:
                        View barrier = new Barrier(constraintLayout.getContext());
                        barrier.setId(num.intValue());
                        if (c31827a2.f14536fn != null) {
                            barrier.setReferencedIds(c31827a2.f14536fn);
                        } else if (c31827a2.f14537fo != null) {
                            c31827a2.f14536fn = C37095a.m62055a(barrier, c31827a2.f14537fo);
                            barrier.setReferencedIds(c31827a2.f14536fn);
                        }
                        barrier.setType(c31827a2.f14534fk);
                        LayoutParams as = ConstraintLayout.m72361as();
                        barrier.mo66107ap();
                        c31827a2.mo51787a(as);
                        constraintLayout.addView(barrier, as);
                        break;
                }
            }
            if (c31827a2.f14506eN) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                LayoutParams as2 = ConstraintLayout.m72361as();
                c31827a2.mo51787a(as2);
                constraintLayout.addView(guideline, as2);
            }
        }
    }

    /* renamed from: a */
    private static int m62053a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    /* renamed from: a */
    static void m62054a(C31827a c31827a, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (f15656eM.get(index)) {
                case 1:
                    c31827a.f14487dJ = C37095a.m62053a(typedArray, index, c31827a.f14487dJ);
                    break;
                case 2:
                    c31827a.bottomMargin = typedArray.getDimensionPixelSize(index, c31827a.bottomMargin);
                    break;
                case 3:
                    c31827a.f14486dI = C37095a.m62053a(typedArray, index, c31827a.f14486dI);
                    break;
                case 4:
                    c31827a.f14485dH = C37095a.m62053a(typedArray, index, c31827a.f14485dH);
                    break;
                case 5:
                    c31827a.f14503dZ = typedArray.getString(index);
                    break;
                case 6:
                    c31827a.f14521em = typedArray.getDimensionPixelOffset(index, c31827a.f14521em);
                    break;
                case 7:
                    c31827a.f14522eo = typedArray.getDimensionPixelOffset(index, c31827a.f14522eo);
                    break;
                case 8:
                    c31827a.f14508eP = typedArray.getDimensionPixelSize(index, c31827a.f14508eP);
                    break;
                case 9:
                    c31827a.f14494dQ = C37095a.m62053a(typedArray, index, c31827a.f14494dQ);
                    break;
                case 10:
                    c31827a.f14493dP = C37095a.m62053a(typedArray, index, c31827a.f14493dP);
                    break;
                case 11:
                    c31827a.f14498dU = typedArray.getDimensionPixelSize(index, c31827a.f14498dU);
                    break;
                case 12:
                    c31827a.f14500dW = typedArray.getDimensionPixelSize(index, c31827a.f14500dW);
                    break;
                case 13:
                    c31827a.f14495dR = typedArray.getDimensionPixelSize(index, c31827a.f14495dR);
                    break;
                case 14:
                    c31827a.f14497dT = typedArray.getDimensionPixelSize(index, c31827a.f14497dT);
                    break;
                case 15:
                    c31827a.f14499dV = typedArray.getDimensionPixelSize(index, c31827a.f14499dV);
                    break;
                case 16:
                    c31827a.f14496dS = typedArray.getDimensionPixelSize(index, c31827a.f14496dS);
                    break;
                case 17:
                    c31827a.f14504dw = typedArray.getDimensionPixelOffset(index, c31827a.f14504dw);
                    break;
                case 18:
                    c31827a.f14505dz = typedArray.getDimensionPixelOffset(index, c31827a.f14505dz);
                    break;
                case 19:
                    c31827a.f14478dA = typedArray.getFloat(index, c31827a.f14478dA);
                    break;
                case 20:
                    c31827a.f14501dX = typedArray.getFloat(index, c31827a.f14501dX);
                    break;
                case 21:
                    c31827a.mHeight = typedArray.getLayoutDimension(index, c31827a.mHeight);
                    break;
                case 22:
                    c31827a.visibility = typedArray.getInt(index, c31827a.visibility);
                    c31827a.visibility = f15655eK[c31827a.visibility];
                    break;
                case 23:
                    c31827a.mWidth = typedArray.getLayoutDimension(index, c31827a.mWidth);
                    break;
                case 24:
                    c31827a.leftMargin = typedArray.getDimensionPixelSize(index, c31827a.leftMargin);
                    break;
                case 25:
                    c31827a.f14479dB = C37095a.m62053a(typedArray, index, c31827a.f14479dB);
                    break;
                case 26:
                    c31827a.f14480dC = C37095a.m62053a(typedArray, index, c31827a.f14480dC);
                    break;
                case 27:
                    c31827a.orientation = typedArray.getInt(index, c31827a.orientation);
                    break;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c31827a.rightMargin = typedArray.getDimensionPixelSize(index, c31827a.rightMargin);
                    break;
                case 29:
                    c31827a.f14481dD = C37095a.m62053a(typedArray, index, c31827a.f14481dD);
                    break;
                case 30:
                    c31827a.f14482dE = C37095a.m62053a(typedArray, index, c31827a.f14482dE);
                    break;
                case 31:
                    c31827a.f14509eQ = typedArray.getDimensionPixelSize(index, c31827a.f14509eQ);
                    break;
                case 32:
                    c31827a.f14491dN = C37095a.m62053a(typedArray, index, c31827a.f14491dN);
                    break;
                case 33:
                    c31827a.f14492dO = C37095a.m62053a(typedArray, index, c31827a.f14492dO);
                    break;
                case 34:
                    c31827a.topMargin = typedArray.getDimensionPixelSize(index, c31827a.topMargin);
                    break;
                case 35:
                    c31827a.f14484dG = C37095a.m62053a(typedArray, index, c31827a.f14484dG);
                    break;
                case 36:
                    c31827a.f14483dF = C37095a.m62053a(typedArray, index, c31827a.f14483dF);
                    break;
                case C2275g.CTRL_INDEX /*37*/:
                    c31827a.f14502dY = typedArray.getFloat(index, c31827a.f14502dY);
                    break;
                case 38:
                    c31827a.f14507eO = typedArray.getResourceId(index, c31827a.f14507eO);
                    break;
                case 39:
                    c31827a.horizontalWeight = typedArray.getFloat(index, c31827a.horizontalWeight);
                    break;
                case 40:
                    c31827a.verticalWeight = typedArray.getFloat(index, c31827a.verticalWeight);
                    break;
                case 41:
                    c31827a.f14519ec = typedArray.getInt(index, c31827a.f14519ec);
                    break;
                case 42:
                    c31827a.f14520ed = typedArray.getInt(index, c31827a.f14520ed);
                    break;
                case 43:
                    c31827a.alpha = typedArray.getFloat(index, c31827a.alpha);
                    break;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    c31827a.f14510eR = true;
                    c31827a.f14511eS = typedArray.getDimension(index, c31827a.f14511eS);
                    break;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    c31827a.f14512eT = typedArray.getFloat(index, c31827a.f14512eT);
                    break;
                case 46:
                    c31827a.f14513eU = typedArray.getFloat(index, c31827a.f14513eU);
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    c31827a.scaleX = typedArray.getFloat(index, c31827a.scaleX);
                    break;
                case 48:
                    c31827a.scaleY = typedArray.getFloat(index, c31827a.scaleY);
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    c31827a.f14514eV = typedArray.getFloat(index, c31827a.f14514eV);
                    break;
                case 50:
                    c31827a.f14515eW = typedArray.getFloat(index, c31827a.f14515eW);
                    break;
                case 51:
                    c31827a.f14516eX = typedArray.getDimension(index, c31827a.f14516eX);
                    break;
                case 52:
                    c31827a.f14517eY = typedArray.getDimension(index, c31827a.f14517eY);
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    c31827a.f14518eZ = typedArray.getDimension(index, c31827a.f14518eZ);
                    break;
                case 60:
                    c31827a.rotation = typedArray.getFloat(index, c31827a.rotation);
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    c31827a.f14488dK = C37095a.m62053a(typedArray, index, c31827a.f14488dK);
                    break;
                case 62:
                    c31827a.f14489dL = typedArray.getDimensionPixelSize(index, c31827a.f14489dL);
                    break;
                case 63:
                    c31827a.f14490dM = typedArray.getFloat(index, c31827a.f14490dM);
                    break;
                case 69:
                    c31827a.f14531fh = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    c31827a.f14532fi = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case C33279c.CTRL_INDEX /*72*/:
                    c31827a.f14534fk = typedArray.getInt(index, c31827a.f14534fk);
                    break;
                case C27077c.CTRL_INDEX /*73*/:
                    c31827a.f14537fo = typedArray.getString(index);
                    break;
                case 74:
                    c31827a.f14533fj = typedArray.getBoolean(index, c31827a.f14533fj);
                    break;
                case 75:
                    new StringBuilder("unused attribute 0x").append(Integer.toHexString(index)).append("   ").append(f15656eM.get(index));
                    break;
                default:
                    new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(index)).append("   ").append(f15656eM.get(index));
                    break;
            }
        }
    }

    /* renamed from: a */
    private static int[] m62055a(View view, String str) {
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i = 0;
        int i2 = 0;
        while (i < split.length) {
            int i3;
            int intValue;
            String trim = split[i].trim();
            try {
                i3 = id.class.getField(trim).getInt(null);
            } catch (Exception e) {
                i3 = 0;
            }
            if (i3 == 0) {
                i3 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i3 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object f = ((ConstraintLayout) view.getParent()).mo66117f(trim);
                if (f != null && (f instanceof Integer)) {
                    intValue = ((Integer) f).intValue();
                    i3 = i2 + 1;
                    iArr[i2] = intValue;
                    i++;
                    i2 = i3;
                }
            }
            intValue = i3;
            i3 = i2 + 1;
            iArr[i2] = intValue;
            i++;
            i2 = i3;
        }
        if (i2 != split.length) {
            return Arrays.copyOf(iArr, i2);
        }
        return iArr;
    }
}
