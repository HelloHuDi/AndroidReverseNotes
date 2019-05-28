package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.R.id;
import android.util.SparseIntArray;
import android.view.View;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    private static final int[] eK = new int[]{0, 4, 8};
    private static SparseIntArray eM;
    HashMap<Integer, a> eL = new HashMap();

    static class a {
        public float alpha;
        public int bottomMargin;
        public float dA;
        public int dB;
        public int dC;
        public int dD;
        public int dE;
        public int dF;
        public int dG;
        public int dH;
        public int dI;
        public int dJ;
        public int dK;
        public int dL;
        public float dM;
        public int dN;
        public int dO;
        public int dP;
        public int dQ;
        public int dR;
        public int dS;
        public int dT;
        public int dU;
        public int dV;
        public int dW;
        public float dX;
        public float dY;
        public String dZ;
        public int dw;
        public int dz;
        boolean eN;
        int eO;
        public int eP;
        public int eQ;
        public boolean eR;
        public float eS;
        public float eT;
        public float eU;
        public float eV;
        public float eW;
        public float eX;
        public float eY;
        public float eZ;
        public int ec;
        public int ed;
        public int em;
        public int eo;
        public boolean ep;
        public boolean eq;
        public int fa;
        public int fb;
        public int fc;
        public int fe;
        public int ff;
        public int fg;
        public float fh;
        public float fi;
        public boolean fj;
        public int fk;
        public int fl;
        public int[] fn;
        public String fo;
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

        private a() {
            this.eN = false;
            this.dw = -1;
            this.dz = -1;
            this.dA = -1.0f;
            this.dB = -1;
            this.dC = -1;
            this.dD = -1;
            this.dE = -1;
            this.dF = -1;
            this.dG = -1;
            this.dH = -1;
            this.dI = -1;
            this.dJ = -1;
            this.dN = -1;
            this.dO = -1;
            this.dP = -1;
            this.dQ = -1;
            this.dX = 0.5f;
            this.dY = 0.5f;
            this.dZ = null;
            this.dK = -1;
            this.dL = 0;
            this.dM = 0.0f;
            this.em = -1;
            this.eo = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.eP = -1;
            this.eQ = -1;
            this.visibility = 0;
            this.dR = -1;
            this.dS = -1;
            this.dT = -1;
            this.dU = -1;
            this.dW = -1;
            this.dV = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.ec = 0;
            this.ed = 0;
            this.alpha = 1.0f;
            this.eR = false;
            this.eS = 0.0f;
            this.rotation = 0.0f;
            this.eT = 0.0f;
            this.eU = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.eV = Float.NaN;
            this.eW = Float.NaN;
            this.eX = 0.0f;
            this.eY = 0.0f;
            this.eZ = 0.0f;
            this.ep = false;
            this.eq = false;
            this.fa = 0;
            this.fb = 0;
            this.fc = -1;
            this.fe = -1;
            this.ff = -1;
            this.fg = -1;
            this.fh = 1.0f;
            this.fi = 1.0f;
            this.fj = false;
            this.fk = -1;
            this.fl = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(LayoutParams layoutParams) {
            layoutParams.dB = this.dB;
            layoutParams.dC = this.dC;
            layoutParams.dD = this.dD;
            layoutParams.dE = this.dE;
            layoutParams.dF = this.dF;
            layoutParams.dG = this.dG;
            layoutParams.dH = this.dH;
            layoutParams.dI = this.dI;
            layoutParams.dJ = this.dJ;
            layoutParams.dN = this.dN;
            layoutParams.dO = this.dO;
            layoutParams.dP = this.dP;
            layoutParams.dQ = this.dQ;
            layoutParams.leftMargin = this.leftMargin;
            layoutParams.rightMargin = this.rightMargin;
            layoutParams.topMargin = this.topMargin;
            layoutParams.bottomMargin = this.bottomMargin;
            layoutParams.dV = this.dV;
            layoutParams.dW = this.dW;
            layoutParams.dX = this.dX;
            layoutParams.dY = this.dY;
            layoutParams.dK = this.dK;
            layoutParams.dL = this.dL;
            layoutParams.dM = this.dM;
            layoutParams.dZ = this.dZ;
            layoutParams.em = this.em;
            layoutParams.eo = this.eo;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.ed = this.ed;
            layoutParams.ec = this.ec;
            layoutParams.ep = this.ep;
            layoutParams.eq = this.eq;
            layoutParams.ee = this.fa;
            layoutParams.ef = this.fb;
            layoutParams.ei = this.fc;
            layoutParams.ej = this.fe;
            layoutParams.eg = this.ff;
            layoutParams.eh = this.fg;
            layoutParams.ek = this.fh;
            layoutParams.el = this.fi;
            layoutParams.orientation = this.orientation;
            layoutParams.dA = this.dA;
            layoutParams.dw = this.dw;
            layoutParams.dz = this.dz;
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mHeight;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.eQ);
                layoutParams.setMarginEnd(this.eP);
            }
            layoutParams.validate();
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, Constraints.LayoutParams layoutParams) {
            this.eO = i;
            this.dB = layoutParams.dB;
            this.dC = layoutParams.dC;
            this.dD = layoutParams.dD;
            this.dE = layoutParams.dE;
            this.dF = layoutParams.dF;
            this.dG = layoutParams.dG;
            this.dH = layoutParams.dH;
            this.dI = layoutParams.dI;
            this.dJ = layoutParams.dJ;
            this.dN = layoutParams.dN;
            this.dO = layoutParams.dO;
            this.dP = layoutParams.dP;
            this.dQ = layoutParams.dQ;
            this.dX = layoutParams.dX;
            this.dY = layoutParams.dY;
            this.dZ = layoutParams.dZ;
            this.dK = layoutParams.dK;
            this.dL = layoutParams.dL;
            this.dM = layoutParams.dM;
            this.em = layoutParams.em;
            this.eo = layoutParams.eo;
            this.orientation = layoutParams.orientation;
            this.dA = layoutParams.dA;
            this.dw = layoutParams.dw;
            this.dz = layoutParams.dz;
            this.mWidth = layoutParams.width;
            this.mHeight = layoutParams.height;
            this.leftMargin = layoutParams.leftMargin;
            this.rightMargin = layoutParams.rightMargin;
            this.topMargin = layoutParams.topMargin;
            this.bottomMargin = layoutParams.bottomMargin;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.ed = layoutParams.ed;
            this.ec = layoutParams.ec;
            this.ep = layoutParams.ep;
            this.eq = layoutParams.eq;
            this.fa = layoutParams.ee;
            this.fb = layoutParams.ef;
            this.ep = layoutParams.ep;
            this.fc = layoutParams.ei;
            this.fe = layoutParams.ej;
            this.ff = layoutParams.eg;
            this.fg = layoutParams.eh;
            this.fh = layoutParams.ek;
            this.fi = layoutParams.el;
            if (VERSION.SDK_INT >= 17) {
                this.eP = layoutParams.getMarginEnd();
                this.eQ = layoutParams.getMarginStart();
            }
            this.alpha = layoutParams.alpha;
            this.rotation = layoutParams.rotation;
            this.eT = layoutParams.eT;
            this.eU = layoutParams.eU;
            this.scaleX = layoutParams.scaleX;
            this.scaleY = layoutParams.scaleY;
            this.eV = layoutParams.eV;
            this.eW = layoutParams.eW;
            this.eX = layoutParams.eX;
            this.eY = layoutParams.eY;
            this.eZ = layoutParams.eZ;
            this.eS = layoutParams.eS;
            this.eR = layoutParams.eR;
        }

        public final /* synthetic */ Object clone() {
            a aVar = new a();
            aVar.eN = this.eN;
            aVar.mWidth = this.mWidth;
            aVar.mHeight = this.mHeight;
            aVar.dw = this.dw;
            aVar.dz = this.dz;
            aVar.dA = this.dA;
            aVar.dB = this.dB;
            aVar.dC = this.dC;
            aVar.dD = this.dD;
            aVar.dE = this.dE;
            aVar.dF = this.dF;
            aVar.dG = this.dG;
            aVar.dH = this.dH;
            aVar.dI = this.dI;
            aVar.dJ = this.dJ;
            aVar.dN = this.dN;
            aVar.dO = this.dO;
            aVar.dP = this.dP;
            aVar.dQ = this.dQ;
            aVar.dX = this.dX;
            aVar.dY = this.dY;
            aVar.dZ = this.dZ;
            aVar.em = this.em;
            aVar.eo = this.eo;
            aVar.dX = this.dX;
            aVar.dX = this.dX;
            aVar.dX = this.dX;
            aVar.dX = this.dX;
            aVar.dX = this.dX;
            aVar.orientation = this.orientation;
            aVar.leftMargin = this.leftMargin;
            aVar.rightMargin = this.rightMargin;
            aVar.topMargin = this.topMargin;
            aVar.bottomMargin = this.bottomMargin;
            aVar.eP = this.eP;
            aVar.eQ = this.eQ;
            aVar.visibility = this.visibility;
            aVar.dR = this.dR;
            aVar.dS = this.dS;
            aVar.dT = this.dT;
            aVar.dU = this.dU;
            aVar.dW = this.dW;
            aVar.dV = this.dV;
            aVar.verticalWeight = this.verticalWeight;
            aVar.horizontalWeight = this.horizontalWeight;
            aVar.ec = this.ec;
            aVar.ed = this.ed;
            aVar.alpha = this.alpha;
            aVar.eR = this.eR;
            aVar.eS = this.eS;
            aVar.rotation = this.rotation;
            aVar.eT = this.eT;
            aVar.eU = this.eU;
            aVar.scaleX = this.scaleX;
            aVar.scaleY = this.scaleY;
            aVar.eV = this.eV;
            aVar.eW = this.eW;
            aVar.eX = this.eX;
            aVar.eY = this.eY;
            aVar.eZ = this.eZ;
            aVar.ep = this.ep;
            aVar.eq = this.eq;
            aVar.fa = this.fa;
            aVar.fb = this.fb;
            aVar.fc = this.fc;
            aVar.fe = this.fe;
            aVar.ff = this.ff;
            aVar.fg = this.fg;
            aVar.fh = this.fh;
            aVar.fi = this.fi;
            aVar.fk = this.fk;
            aVar.fl = this.fl;
            if (this.fn != null) {
                aVar.fn = Arrays.copyOf(this.fn, this.fn.length);
            }
            aVar.dK = this.dK;
            aVar.dL = this.dL;
            aVar.dM = this.dM;
            aVar.fj = this.fj;
            return aVar;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        eM = sparseIntArray;
        sparseIntArray.append(55, 25);
        eM.append(56, 26);
        eM.append(58, 29);
        eM.append(59, 30);
        eM.append(64, 36);
        eM.append(63, 35);
        eM.append(37, 4);
        eM.append(36, 3);
        eM.append(34, 1);
        eM.append(72, 6);
        eM.append(73, 7);
        eM.append(44, 17);
        eM.append(45, 18);
        eM.append(46, 19);
        eM.append(0, 27);
        eM.append(60, 32);
        eM.append(61, 33);
        eM.append(43, 10);
        eM.append(42, 9);
        eM.append(76, 13);
        eM.append(79, 16);
        eM.append(77, 14);
        eM.append(74, 11);
        eM.append(78, 15);
        eM.append(75, 12);
        eM.append(67, 40);
        eM.append(53, 39);
        eM.append(52, 41);
        eM.append(66, 42);
        eM.append(51, 20);
        eM.append(65, 37);
        eM.append(41, 5);
        eM.append(54, 75);
        eM.append(62, 75);
        eM.append(57, 75);
        eM.append(35, 75);
        eM.append(33, 75);
        eM.append(5, 24);
        eM.append(7, 28);
        eM.append(23, 31);
        eM.append(24, 8);
        eM.append(6, 34);
        eM.append(8, 2);
        eM.append(3, 23);
        eM.append(4, 21);
        eM.append(2, 22);
        eM.append(13, 43);
        eM.append(26, 44);
        eM.append(21, 45);
        eM.append(22, 46);
        eM.append(20, 60);
        eM.append(18, 47);
        eM.append(19, 48);
        eM.append(14, 49);
        eM.append(15, 50);
        eM.append(16, 51);
        eM.append(17, 52);
        eM.append(25, 53);
        eM.append(68, 54);
        eM.append(47, 55);
        eM.append(69, 56);
        eM.append(48, 57);
        eM.append(70, 58);
        eM.append(49, 59);
        eM.append(38, 61);
        eM.append(40, 62);
        eM.append(39, 63);
        eM.append(1, 38);
        eM.append(71, 69);
        eM.append(50, 70);
        eM.append(29, 71);
        eM.append(28, 72);
        eM.append(30, 73);
        eM.append(27, 74);
    }

    /* Access modifiers changed, original: final */
    public final void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.eL.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.eL.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = (a) this.eL.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.fl = 1;
                }
                if (aVar.fl != -1) {
                    switch (aVar.fl) {
                        case 1:
                            View view = (Barrier) childAt;
                            view.setId(id);
                            view.setType(aVar.fk);
                            view.setAllowsGoneWidget(aVar.fj);
                            if (aVar.fn == null) {
                                if (aVar.fo != null) {
                                    aVar.fn = a(view, aVar.fo);
                                    view.setReferencedIds(aVar.fn);
                                    break;
                                }
                            }
                            view.setReferencedIds(aVar.fn);
                            break;
                            break;
                    }
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                aVar.a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(aVar.visibility);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.alpha);
                    childAt.setRotation(aVar.rotation);
                    childAt.setRotationX(aVar.eT);
                    childAt.setRotationY(aVar.eU);
                    childAt.setScaleX(aVar.scaleX);
                    childAt.setScaleY(aVar.scaleY);
                    if (!Float.isNaN(aVar.eV)) {
                        childAt.setPivotX(aVar.eV);
                    }
                    if (!Float.isNaN(aVar.eW)) {
                        childAt.setPivotY(aVar.eW);
                    }
                    childAt.setTranslationX(aVar.eX);
                    childAt.setTranslationY(aVar.eY);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.eZ);
                        if (aVar.eR) {
                            childAt.setElevation(aVar.eS);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.eL.get(num);
            if (aVar2.fl != -1) {
                switch (aVar2.fl) {
                    case 1:
                        View barrier = new Barrier(constraintLayout.getContext());
                        barrier.setId(num.intValue());
                        if (aVar2.fn != null) {
                            barrier.setReferencedIds(aVar2.fn);
                        } else if (aVar2.fo != null) {
                            aVar2.fn = a(barrier, aVar2.fo);
                            barrier.setReferencedIds(aVar2.fn);
                        }
                        barrier.setType(aVar2.fk);
                        LayoutParams as = ConstraintLayout.as();
                        barrier.ap();
                        aVar2.a(as);
                        constraintLayout.addView(barrier, as);
                        break;
                }
            }
            if (aVar2.eN) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                LayoutParams as2 = ConstraintLayout.as();
                aVar2.a(as2);
                constraintLayout.addView(guideline, as2);
            }
        }
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    static void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (eM.get(index)) {
                case 1:
                    aVar.dJ = a(typedArray, index, aVar.dJ);
                    break;
                case 2:
                    aVar.bottomMargin = typedArray.getDimensionPixelSize(index, aVar.bottomMargin);
                    break;
                case 3:
                    aVar.dI = a(typedArray, index, aVar.dI);
                    break;
                case 4:
                    aVar.dH = a(typedArray, index, aVar.dH);
                    break;
                case 5:
                    aVar.dZ = typedArray.getString(index);
                    break;
                case 6:
                    aVar.em = typedArray.getDimensionPixelOffset(index, aVar.em);
                    break;
                case 7:
                    aVar.eo = typedArray.getDimensionPixelOffset(index, aVar.eo);
                    break;
                case 8:
                    aVar.eP = typedArray.getDimensionPixelSize(index, aVar.eP);
                    break;
                case 9:
                    aVar.dQ = a(typedArray, index, aVar.dQ);
                    break;
                case 10:
                    aVar.dP = a(typedArray, index, aVar.dP);
                    break;
                case 11:
                    aVar.dU = typedArray.getDimensionPixelSize(index, aVar.dU);
                    break;
                case 12:
                    aVar.dW = typedArray.getDimensionPixelSize(index, aVar.dW);
                    break;
                case 13:
                    aVar.dR = typedArray.getDimensionPixelSize(index, aVar.dR);
                    break;
                case 14:
                    aVar.dT = typedArray.getDimensionPixelSize(index, aVar.dT);
                    break;
                case 15:
                    aVar.dV = typedArray.getDimensionPixelSize(index, aVar.dV);
                    break;
                case 16:
                    aVar.dS = typedArray.getDimensionPixelSize(index, aVar.dS);
                    break;
                case 17:
                    aVar.dw = typedArray.getDimensionPixelOffset(index, aVar.dw);
                    break;
                case 18:
                    aVar.dz = typedArray.getDimensionPixelOffset(index, aVar.dz);
                    break;
                case 19:
                    aVar.dA = typedArray.getFloat(index, aVar.dA);
                    break;
                case 20:
                    aVar.dX = typedArray.getFloat(index, aVar.dX);
                    break;
                case 21:
                    aVar.mHeight = typedArray.getLayoutDimension(index, aVar.mHeight);
                    break;
                case 22:
                    aVar.visibility = typedArray.getInt(index, aVar.visibility);
                    aVar.visibility = eK[aVar.visibility];
                    break;
                case 23:
                    aVar.mWidth = typedArray.getLayoutDimension(index, aVar.mWidth);
                    break;
                case 24:
                    aVar.leftMargin = typedArray.getDimensionPixelSize(index, aVar.leftMargin);
                    break;
                case 25:
                    aVar.dB = a(typedArray, index, aVar.dB);
                    break;
                case 26:
                    aVar.dC = a(typedArray, index, aVar.dC);
                    break;
                case 27:
                    aVar.orientation = typedArray.getInt(index, aVar.orientation);
                    break;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    aVar.rightMargin = typedArray.getDimensionPixelSize(index, aVar.rightMargin);
                    break;
                case 29:
                    aVar.dD = a(typedArray, index, aVar.dD);
                    break;
                case 30:
                    aVar.dE = a(typedArray, index, aVar.dE);
                    break;
                case 31:
                    aVar.eQ = typedArray.getDimensionPixelSize(index, aVar.eQ);
                    break;
                case 32:
                    aVar.dN = a(typedArray, index, aVar.dN);
                    break;
                case 33:
                    aVar.dO = a(typedArray, index, aVar.dO);
                    break;
                case 34:
                    aVar.topMargin = typedArray.getDimensionPixelSize(index, aVar.topMargin);
                    break;
                case 35:
                    aVar.dG = a(typedArray, index, aVar.dG);
                    break;
                case 36:
                    aVar.dF = a(typedArray, index, aVar.dF);
                    break;
                case g.CTRL_INDEX /*37*/:
                    aVar.dY = typedArray.getFloat(index, aVar.dY);
                    break;
                case 38:
                    aVar.eO = typedArray.getResourceId(index, aVar.eO);
                    break;
                case 39:
                    aVar.horizontalWeight = typedArray.getFloat(index, aVar.horizontalWeight);
                    break;
                case 40:
                    aVar.verticalWeight = typedArray.getFloat(index, aVar.verticalWeight);
                    break;
                case 41:
                    aVar.ec = typedArray.getInt(index, aVar.ec);
                    break;
                case 42:
                    aVar.ed = typedArray.getInt(index, aVar.ed);
                    break;
                case 43:
                    aVar.alpha = typedArray.getFloat(index, aVar.alpha);
                    break;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    aVar.eR = true;
                    aVar.eS = typedArray.getDimension(index, aVar.eS);
                    break;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    aVar.eT = typedArray.getFloat(index, aVar.eT);
                    break;
                case 46:
                    aVar.eU = typedArray.getFloat(index, aVar.eU);
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    aVar.scaleX = typedArray.getFloat(index, aVar.scaleX);
                    break;
                case 48:
                    aVar.scaleY = typedArray.getFloat(index, aVar.scaleY);
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    aVar.eV = typedArray.getFloat(index, aVar.eV);
                    break;
                case 50:
                    aVar.eW = typedArray.getFloat(index, aVar.eW);
                    break;
                case 51:
                    aVar.eX = typedArray.getDimension(index, aVar.eX);
                    break;
                case 52:
                    aVar.eY = typedArray.getDimension(index, aVar.eY);
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    aVar.eZ = typedArray.getDimension(index, aVar.eZ);
                    break;
                case 60:
                    aVar.rotation = typedArray.getFloat(index, aVar.rotation);
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    aVar.dK = a(typedArray, index, aVar.dK);
                    break;
                case 62:
                    aVar.dL = typedArray.getDimensionPixelSize(index, aVar.dL);
                    break;
                case 63:
                    aVar.dM = typedArray.getFloat(index, aVar.dM);
                    break;
                case 69:
                    aVar.fh = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.fi = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case c.CTRL_INDEX /*72*/:
                    aVar.fk = typedArray.getInt(index, aVar.fk);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
                    aVar.fo = typedArray.getString(index);
                    break;
                case 74:
                    aVar.fj = typedArray.getBoolean(index, aVar.fj);
                    break;
                case 75:
                    new StringBuilder("unused attribute 0x").append(Integer.toHexString(index)).append("   ").append(eM.get(index));
                    break;
                default:
                    new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(index)).append("   ").append(eM.get(index));
                    break;
            }
        }
    }

    private static int[] a(View view, String str) {
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
                Object f = ((ConstraintLayout) view.getParent()).f(trim);
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
