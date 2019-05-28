package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.C41106g;
import java.util.List;

public class ChannelTranslateFilter extends BaseFilter {
    private static String FRAGMENT_SHADER = "mee2052x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1746954094x1885890409x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853164042x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x1963604837x1868982638x1713401202x1952542572x1684369952x1963604824x1868982638x1713401202x1952542572x1684369952x1963604825x1868982638x1713401202x1952542572x1701996320x995651173x1768846602x1836216166x1869375008x1730180193x1852138866x1963604825x1868982638x1713401202x1952542572x1970037280x171661413x1718185589x544043631x1634692198x1818370164x995714421x1768846602x1836216166x2003790880x1852383344x2019893364x1952671088x1701011782x1963597883x1868982638x1746955634x1885890409x1667593760x1634082866x1698915683x1919251566x1853164091x1919903337x1768431725x544237671x1634692198x1634869364x1937074532x1963604812x1868982638x1746955634x1885890409x1869375008x1914729569x1969841249x993088371x1768846602x1836216166x1734961184x1713401960x1952542572x1684107808x1400075625x1963604786x1868982638x1746955634x1885890409x1869375008x1998615649x1752458345x1853164091x1919903337x1768431725x544237671x1634692198x1701322868x1952999273x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1282568052x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1400008564x1980369467x543451503x1852399981x2064263464x538976266x1667593760x1919885364x1852401513x1869377347x540876914x1954047348x845509237x1852385348x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x538976266x1869375008x1914729569x1025533029x1769107232x1131309415x1919904879x540768302x538976266x1869375008x1730180193x1852138866x1864383776x1768384882x1819231086x2033087087x537534523x1713381408x1952542572x1970037280x540876901x1734963823x1866690153x779251564x169884538x538976288x1634692198x1701716084x1684361847x1864383776x1768384882x1819231086x2016309871x537534523x1713381408x1952542572x2003136032x1701147207x540876910x1734963823x1866690153x779251564x169884537x538976288x1634692198x1701716084x1970029175x540876901x1734963823x1866690153x779251564x169884538x538976288x1634692198x543236212x774971453x169884464x538976288x673212009x1701869669x1632007267x1025533283x540090429x1713382950x1130718049x1702129253x544747122x774905918x640032816x1667327520x1852130149x779249012x540942457x691023408x169900832x538976288x538976288x1634692198x544743540x1702109245x1920300152x1869562725x1852400754x778400865x539631736x1952737655x537541480x538976288x1713381408x1952542572x1025538336x2019914784x1701999988x1919905603x1634625892x2033083764x1746938400x1751607653x537541492x538976288x1981816864x540173157x544434532x1702240317x2015900259x1667327533x1852130149x779249012x2032151672x1667327533x1852130149x779249012x171649401x538976288x538976288x1634692198x1768169588x541881459x1768169533x544747123x1702240298x1919906915x544747084x1768169515x544812659x1702240298x1919906915x997797452x538970656x538976288x1818632224x544498031x1953720676x540876883x779315556x539631736x1952671094x777220719x539697272x779315556x539631737x1952671094x777220719x169884537x538976288x538976288x1634692198x1399988340x1914715424x1969841249x993088371x538970656x538976288x1718165536x1768171552x542340211x774905918x2065705264x538970656x538976288x538976288x1399988256x1914715424x1969841249x993153907x538970656x538976288x545071136x538976266x538976288x1869375008x1679848545x544502633x1680351293x1282700137x1914711840x1969841249x539577459x1680351274x1282700137x1914711840x1969841249x539577459x1680351275x1400140649x1914711840x706750803x1768171552x542340211x1399988271x169884457x538976288x538976288x1680369257x544502633x807419196x539572526x538970747x538976288x538976288x543236128x774905917x169884464x538976288x538976288x1818566781x1763730803x1680351334x544502633x824196412x539570222x538970747x538976288x538976288x543236128x1680351293x544502633x774905901x706750777x774910240x169884464x538976288x538976288x537534589x2099257376x538976266x543582496x1684369960x1025581144x808333344x545029152x1499751794x540877088x691023408x169900832x538976288x538976288x1383556462x1025533029x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x543519841x1702240299x1915236963x743990373x1684369952x774449497x169884536x538976288x537534589x1763713056x1730682982x1852138866x1025581144x808333344x545029152x1701147239x555768174x774905917x2065705264x538970656x538976288x1701716000x1701988215x1025535589x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x543519841x1702240299x1730687587x1852138866x1730161752x1852138866x774449497x169884537x538976288x537534589x1763713056x1646796902x1483044204x540877088x540028464x1646296188x1499821420x540877088x691023408x169900832x538976288x538976288x1115121006x543520108x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x1948265573x1970567269x1866687858x1768190575x1702125934x1981819680x674390885x1702194274x1646275672x1499821420x2049845545x537534523x2099257376x538970656x1701978144x540876900x678979949x744777074x2003136032x744777042x992567584x538976266x1701996320x1025535589x2020175136x1701996328x539782757x1199007086x1852138866x694231084x538970683x1818370080x1025533301x2020175136x1970037288x1847602277x1816295269x539780469x171649377x538976266x1600939808x1734439494x1869377347x540876914x878929270x1684369960x1919361068x745432421x1970037280x1864379493x1768384882x1819231086x1630433903x2097822505x";
    private int expectFace = 1;
    private float[] faceCenter = new float[]{0.0f, 0.0f};
    private float radiusL = 0.0f;
    private float radiusS1 = 0.0f;
    private float radiusS2 = 0.0f;
    private byte[] rgbaBuffer;
    private float[] vectorL = new float[]{0.0f, 1.0f};
    private float[] vectorS = new float[]{1.0f, 0.0f};

    public ChannelTranslateFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82092);
        initParams();
        AppMethodBeat.m2505o(82092);
    }

    public void setRedX(float f) {
        AppMethodBeat.m2504i(82093);
        addParam(new C0933f("redX", f));
        AppMethodBeat.m2505o(82093);
    }

    public void setRedY(float f) {
        AppMethodBeat.m2504i(82094);
        addParam(new C0933f("redY", f));
        AppMethodBeat.m2505o(82094);
    }

    public void setGreenX(float f) {
        AppMethodBeat.m2504i(82095);
        addParam(new C0933f("greenX", f));
        AppMethodBeat.m2505o(82095);
    }

    public void setGreenY(float f) {
        AppMethodBeat.m2504i(82096);
        addParam(new C0933f("greenY", f));
        AppMethodBeat.m2505o(82096);
    }

    public void setBlueX(float f) {
        AppMethodBeat.m2504i(82097);
        addParam(new C0933f("blueX", f));
        AppMethodBeat.m2505o(82097);
    }

    public void setBlueY(float f) {
        AppMethodBeat.m2504i(82098);
        addParam(new C0933f("blueY", f));
        AppMethodBeat.m2505o(82098);
    }

    public void setExceptFace(int i) {
        AppMethodBeat.m2504i(82099);
        this.expectFace = i;
        addParam(new C0935i("expectFace", i));
        AppMethodBeat.m2505o(82099);
    }

    private void initParams() {
        AppMethodBeat.m2504i(82100);
        addParam(new C0933f("redX", 0.0f));
        addParam(new C0933f("redY", 0.0f));
        addParam(new C0933f("greenX", 0.0f));
        addParam(new C0933f("greenY", 0.0f));
        addParam(new C0933f("blueX", 0.0f));
        addParam(new C0933f("blueY", 0.0f));
        addParam(new C0935i("expectFace", this.expectFace));
        AppMethodBeat.m2505o(82100);
    }

    public void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82101);
        if (this.expectFace == 1) {
            if (this.rgbaBuffer == null || this.rgbaBuffer.length != (i2 * i3) * 4) {
                this.rgbaBuffer = new byte[((i2 * i3) * 4)];
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            C41106g.m71540a(i, i2, i3, this.rgbaBuffer, iArr[0]);
            VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector = new VideoPreviewFaceOutlineDetector();
            videoPreviewFaceOutlineDetector.init();
            videoPreviewFaceOutlineDetector.doFaceDetect(this.rgbaBuffer, i2, i3);
            videoPreviewFaceOutlineDetector.doTrack(this.rgbaBuffer, i2, i3);
            List allPoints = videoPreviewFaceOutlineDetector.getAllPoints(0);
            videoPreviewFaceOutlineDetector.destroy();
            if (allPoints == null || allPoints.size() <= 88) {
                AppMethodBeat.m2505o(82101);
                return;
            }
            Rect rect = new Rect();
            rect.left = (int) ((PointF) allPoints.get(86)).x;
            rect.top = (int) Math.min(((PointF) allPoints.get(86)).y, ((PointF) allPoints.get(88)).y);
            rect.right = (int) ((PointF) allPoints.get(88)).x;
            rect.bottom = (int) ((PointF) allPoints.get(9)).y;
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            if (rect.right > i2) {
                rect.right = i2;
            }
            if (rect.bottom > i3) {
                rect.bottom = i3;
            }
            this.faceCenter[0] = (float) rect.centerX();
            this.faceCenter[1] = (float) rect.centerY();
            this.radiusL = ((float) Math.sqrt((double) (((((PointF) allPoints.get(9)).y - this.faceCenter[1]) * (((PointF) allPoints.get(9)).y - this.faceCenter[1])) + ((((PointF) allPoints.get(9)).x - this.faceCenter[0]) * (((PointF) allPoints.get(9)).x - this.faceCenter[0]))))) * 1.05f;
            addParam(new C0934g("faceCenter", this.faceCenter));
            addParam(new C0933f("radiusL", this.radiusL));
            this.vectorL[0] = ((PointF) allPoints.get(9)).x - ((float) rect.centerX());
            this.vectorL[1] = ((PointF) allPoints.get(9)).y - ((float) rect.centerY());
            float sqrt = (float) Math.sqrt((double) ((this.vectorL[0] * this.vectorL[0]) + (this.vectorL[1] * this.vectorL[1])));
            if (sqrt > 0.0f) {
                float[] fArr = this.vectorL;
                fArr[0] = fArr[0] / sqrt;
                fArr = this.vectorL;
                fArr[1] = fArr[1] / sqrt;
            }
            addParam(new C0934g("vectorL", this.vectorL));
            this.vectorS[0] = this.vectorL[1];
            this.vectorS[1] = -this.vectorL[0];
            addParam(new C0934g("vectorS", this.vectorS));
            this.radiusS1 = Math.abs(((((PointF) allPoints.get(0)).y - this.faceCenter[1]) * this.vectorS[1]) + (this.vectorS[0] * (((PointF) allPoints.get(0)).x - this.faceCenter[0]))) * 1.05f;
            this.radiusS2 = Math.abs(((((PointF) allPoints.get(18)).y - this.faceCenter[1]) * this.vectorS[1]) + (this.vectorS[0] * (((PointF) allPoints.get(18)).x - this.faceCenter[0]))) * 1.05f;
            addParam(new C0933f("radiusS1", this.radiusS1));
            addParam(new C0933f("radiusS2", this.radiusS2));
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
        super.beforeRender(i, i2, i3);
        AppMethodBeat.m2505o(82101);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82102);
        addParam(new C0934g("faceCenter", this.faceCenter));
        addParam(new C0933f("radiusL", this.radiusL));
        addParam(new C0933f("radiusS1", this.radiusS1));
        addParam(new C0933f("radiusS2", this.radiusS2));
        addParam(new C0934g("vectorL", this.vectorL));
        addParam(new C0934g("vectorS", this.vectorS));
        addParam(new C0933f("width", f));
        addParam(new C0933f("height", f2));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82102);
    }
}
