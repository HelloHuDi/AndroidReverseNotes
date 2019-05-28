package android.support.c.a;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.view.b.a;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class d {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Interpolator loadInterpolator(Context context, int i) {
        Throwable e;
        XmlResourceParser xmlResourceParser;
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser2 = null;
        if (VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        if (i == 17563663) {
            try {
                return new a();
            } catch (XmlPullParserException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
                xmlResourceParser = null;
                try {
                    notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                } catch (Throwable th) {
                    e = th;
                    if (xmlResourceParser != null) {
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                xmlResourceParser = null;
                if (xmlResourceParser != null) {
                }
                throw e;
            }
        } else if (i == 17563661) {
            return new b();
        } else {
            if (i == 17563662) {
                return new c();
            }
            xmlResourceParser = context.getResources().getAnimation(i);
            try {
                context.getResources();
                context.getTheme();
                int depth = xmlResourceParser.getDepth();
                Interpolator interpolator = null;
                while (true) {
                    int next = xmlResourceParser.next();
                    if ((next != 3 || xmlResourceParser.getDepth() > depth) && next != 1) {
                        if (next == 2) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                            String name = xmlResourceParser.getName();
                            if (name.equals("linearInterpolator")) {
                                interpolator = new LinearInterpolator();
                            } else if (name.equals("accelerateInterpolator")) {
                                interpolator = new AccelerateInterpolator(context, asAttributeSet);
                            } else if (name.equals("decelerateInterpolator")) {
                                interpolator = new DecelerateInterpolator(context, asAttributeSet);
                            } else if (name.equals("accelerateDecelerateInterpolator")) {
                                interpolator = new AccelerateDecelerateInterpolator();
                            } else if (name.equals("cycleInterpolator")) {
                                interpolator = new CycleInterpolator(context, asAttributeSet);
                            } else if (name.equals("anticipateInterpolator")) {
                                interpolator = new AnticipateInterpolator(context, asAttributeSet);
                            } else if (name.equals("overshootInterpolator")) {
                                interpolator = new OvershootInterpolator(context, asAttributeSet);
                            } else if (name.equals("anticipateOvershootInterpolator")) {
                                interpolator = new AnticipateOvershootInterpolator(context, asAttributeSet);
                            } else if (name.equals("bounceInterpolator")) {
                                interpolator = new BounceInterpolator();
                            } else if (name.equals("pathInterpolator")) {
                                interpolator = new g(context, asAttributeSet, xmlResourceParser);
                            } else {
                                throw new RuntimeException("Unknown interpolator name: " + xmlResourceParser.getName());
                            }
                        }
                    }
                }
                if (xmlResourceParser == null) {
                    return interpolator;
                }
                xmlResourceParser.close();
                return interpolator;
            } catch (XmlPullParserException e4) {
                e = e4;
                xmlResourceParser2 = xmlResourceParser;
                try {
                    NotFoundException notFoundException2 = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException2.initCause(e);
                    throw notFoundException2;
                } catch (Throwable th3) {
                    e = th3;
                    xmlResourceParser = xmlResourceParser2;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        }
    }
}
