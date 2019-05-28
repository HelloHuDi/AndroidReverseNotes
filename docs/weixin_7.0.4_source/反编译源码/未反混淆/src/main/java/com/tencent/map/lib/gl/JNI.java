package com.tencent.map.lib.gl;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.JNICallback.a;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.JNICallback.g;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.mapstructure.AnnocationText;
import com.tencent.map.lib.mapstructure.AnnocationTextResult;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.CityTrafficInfo;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fk;
import com.tencent.tencentmap.mapsdk.maps.a.gv;
import java.util.ArrayList;

public class JNI {
    public static final String LIB_NAME = "txmapengine";
    private JNICallback a;

    public static native synchronized void nativeEndProfile();

    public static native synchronized void nativeStartProfile();

    public native int getIndoorOutlineZoom(long j, String str);

    public native String getMapEngineRenderStatus(long j);

    public native int nativeAddCircle(long j, CircleInfo circleInfo);

    public native int nativeAddHeatTileOverlay(long j, int i, boolean z);

    public native int nativeAddMarker(long j, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2);

    public native int nativeAddMaskLayer(long j, MaskLayer maskLayer);

    public native int nativeAddPolygon(long j, Polygon2D polygon2D);

    public native void nativeAddRouteNameSegments(long j, byte[][] bArr, int i, GeoPoint[] geoPointArr, int i2);

    public native void nativeAddVIPAnnotationTexts(long j, String str, int i, String str2, GeoPoint geoPoint);

    public native void nativeBringElementAbove(long j, int i, int i2);

    public native void nativeBringElementBelow(long j, int i, int i2);

    public native void nativeCheckTrafficBlockCache(long j, int i, int i2, int i3, int i4, int i5);

    public native void nativeCheckTrafficBlockCacheForReplay(long j, int i, int i2, int i3, int i4, int i5);

    public native int nativeClearCache(long j);

    public native void nativeClearDownloadURLCache(long j);

    public native void nativeClearRouteNameSegments(long j);

    public native void nativeClearVIPAnnotationTexts(long j);

    public native AnnocationTextResult nativeCreateAnnotationTextBitmap(long j, AnnocationText annocationText);

    public native int nativeCreateLine(long j, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int[] iArr3, int[] iArr4, float f2, int[] iArr5, float f3, int i3);

    public native void nativeDeleteCircle(long j, int i);

    public native void nativeDeleteIcons(long j, int[] iArr, int i);

    public native void nativeDeleteLine(long j, long j2, boolean z);

    public native void nativeDeletePolygon(long j, int i, int i2);

    public native void nativeDestroyEngine(long j);

    public native boolean nativeDrawFrame(long j);

    public native void nativeEnablePOI(long j, boolean z);

    public native void nativeEnableVectorMap(long j, boolean z);

    public native int[] nativeFetchLackedTrafficBlocks(long j);

    public native void nativeFromScreenLocation(long j, byte[] bArr, float f, float f2, double[] dArr);

    public native boolean nativeGenerateTextures(long j);

    public native String nativeGetActiveIndoorBuildingGUID(long j);

    public native String nativeGetBlockRouteInfo(long j, int i, int i2);

    public native void nativeGetCenterMapPoint(long j, GeoPoint geoPoint);

    public native byte[] nativeGetCityName(long j, GeoPoint geoPoint);

    public native String nativeGetCurIndoorName(long j, GeoPoint geoPoint);

    public native String nativeGetDataEngineVersion(long j);

    public native boolean nativeGetHeatTileRenderEnabled(long j);

    public native Rect nativeGetIndoorBound(long j);

    public native int nativeGetIndoorCurrentFloorId(long j);

    public native String[] nativeGetIndoorFloorNames(long j);

    public native int nativeGetLanguage(long j);

    public native String nativeGetMapEngineVersion(long j);

    public native int nativeGetMapMode(long j);

    public native ArrayList nativeGetPoisInScreen(long j);

    public native float nativeGetRotate(long j);

    public native double nativeGetScale(long j);

    public native int nativeGetScaleLevel(long j);

    public native float nativeGetSkew(long j);

    public native double nativeGetTargetScale(long j, Rect rect, Rect rect2);

    public native boolean nativeGetTrafficCityInfo(long j, String str, CityTrafficInfo cityTrafficInfo);

    public native boolean nativeHasStreetRoad(long j, String str);

    public native void nativeHideCompass(long j);

    public native void nativeHideIcons(long j, int[] iArr, int i);

    public native void nativeHideStreetRoad(long j);

    public native void nativeHideTraffic(long j);

    public native void nativeIndoorBuildingEnabled(long j, boolean z);

    public native long nativeInitEngine(String str, String str2, String str3, float f, int i, float f2, int[] iArr, boolean z, int i2);

    public native int nativeIsCityHasTraffic(long j, String str);

    public native boolean nativeIsMapDrawFinished(long j);

    public native void nativeLineClearPoint(long j, long j2, GeoPoint geoPoint, int i);

    public native void nativeLineInsertPoint(long j, long j2, GeoPoint geoPoint, int i);

    public native void nativeLoadBlockRouteCityList(long j, int[] iArr, int[] iArr2, int i);

    public native void nativeLockEngine(long j);

    public native void nativeMapLoadKMLFile(long j, String str);

    public native void nativeMoveBy(long j, float f, float f2, boolean z);

    public native boolean nativeNeedDispaly(long j);

    public native boolean nativeNeedRedraw(long j);

    public native byte[] nativeOnTap(long j, float f, float f2);

    public native boolean nativeOnTapLine(long j, float f, float f2);

    public native int nativeQueryCityCodeList(long j, Rect rect, int i, int[] iArr, int i2);

    public native int nativeRefreshTrafficData(long j, byte[] bArr, int i, boolean z, boolean z2);

    public native void nativeReleaseEngineResource(long j, boolean z);

    public native void nativeReloadHeatTileOverlay(long j, int i);

    public native void nativeRemoveHeatTileOverlay(long j, int i);

    public native void nativeRemoveMaskLayer(long j, int i);

    public native void nativeResetEnginePath(long j, String str, String str2, String str3);

    public native void nativeSetBlockRouteVisible(long j, boolean z);

    public native void nativeSetBuilding3DEffect(long j, boolean z);

    public native void nativeSetBuildingToSpecificFloor(long j, String str, String str2);

    public native void nativeSetCallback(long j);

    public native void nativeSetCenter(long j, GeoPoint geoPoint, boolean z);

    public native void nativeSetCenterMapPointAndScaleLevel(long j, GeoPoint geoPoint, int i, boolean z);

    public native void nativeSetCompassMarkerHidden(long j, boolean z);

    public native void nativeSetCompassMarkerImage(long j, String str);

    public native void nativeSetCompassPosition(long j, int i, int i2);

    public native void nativeSetCompassVisible(long j, boolean z);

    public native void nativeSetDrawCap(long j, long j2, boolean z);

    public native void nativeSetFlagOfZoomToSpanForLocation(long j, float f, float f2, float f3, float f4);

    public native void nativeSetHeatTileRenderEnabled(long j, boolean z);

    public native void nativeSetIndoorActiveScreenArea(long j, float f, float f2, float f3, float f4);

    public native void nativeSetIndoorBuildingPickEnabled(long j, boolean z);

    public native void nativeSetIndoorFloor(long j, int i);

    public native void nativeSetIndoorMaskColor(long j, int i);

    public native void nativeSetLanguage(long j, int i);

    public native void nativeSetLineArrowSpacing(long j, int i, float f);

    public native void nativeSetLineDirectionArrowTextureName(long j, long j2, String str);

    public native void nativeSetLineDrawArrow(long j, long j2, boolean z);

    public native void nativeSetLineFootPrintSpacing(long j, int i, float f);

    public native void nativeSetLineSelected(long j, long j2, boolean z);

    public native void nativeSetLocationCircleColor(long j, int i);

    public native void nativeSetLocationCircleHidden(long j, boolean z);

    public native void nativeSetLocationFollow(long j, boolean z, boolean z2, boolean z3, boolean z4);

    public native void nativeSetLocationHeading(long j, float f);

    public native void nativeSetLocationInfo(long j, double d, double d2, float f, float f2, boolean z);

    public native void nativeSetLocationMarkerHidden(long j, boolean z);

    public native void nativeSetLocationMarkerImage(long j, String str);

    public native void nativeSetMapMode(long j, int i, boolean z);

    public native void nativeSetMapParam(long j, byte[] bArr);

    public native void nativeSetMaxScaleLevel(long j, int i);

    public native void nativeSetMinScaleLevel(long j, int i);

    public native void nativeSetNeedDisplay(long j, boolean z);

    public native void nativeSetPriority(long j, int i, float f);

    public native void nativeSetRotate(long j, float f, boolean z);

    public native void nativeSetSatelliteEnabled(long j, boolean z);

    public native void nativeSetScale(long j, double d, boolean z);

    public native void nativeSetScaleLevel(long j, int i, boolean z);

    public native void nativeSetScreenCenterOffset(long j, float f, float f2, boolean z);

    public native void nativeSetServerHost(long j, String str);

    public native void nativeSetShowIndoorBuildingWhiteList(long j, String[] strArr);

    public native void nativeSetSkew(long j, float f, boolean z);

    public native void nativeSetTileOverlayDataLevelRange(long j, int i, int i2, int i3);

    public native void nativeSetTrafficColor(long j, int i, int i2, int i3, int i4);

    public native void nativeSetTurnArrow(long j, long j2, int i, int i2);

    public native void nativeSetTurnArrowStyle(long j, long j2, int i, int i2);

    public native void nativeSetViewport(long j, int i, int i2, int i3, int i4);

    public native void nativeShowStreetRoad(long j);

    public native void nativeShowTraffic(long j);

    public native void nativeToScreenLocation(long j, byte[] bArr, double d, double d2, float[] fArr);

    public native void nativeUnlockEngine(long j);

    public native void nativeUpdateCircle(long j, int i, CircleInfo circleInfo);

    public native void nativeUpdateFrame(long j, double d);

    public native void nativeUpdateMapResource(long j, String str);

    public native void nativeUpdateMarkerInfo(long j, int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3);

    public native void nativeUpdateMaskLayer(long j, int i, int i2);

    public native void nativeUpdatePolygon(long j, int i, int i2, Polygon2D polygon2D);

    public native void nativeWriteMapDataBlock(long j, String str, byte[] bArr);

    public native void nativeZoomIn(long j, float f, float f2);

    public native void nativeZoomOut(long j);

    public native void nativeZoomToSpan(long j, Rect rect, Rect rect2, boolean z);

    public native void nativeZoomToSpanForNavigation(long j, GeoPoint geoPoint, int i, int i2, boolean z);

    public void initCallback(gv gvVar, a aVar, h hVar, e eVar, g gVar, fk fkVar, long j) {
        AppMethodBeat.i(98013);
        this.a = new JNICallback(gvVar, aVar, hVar, eVar, gVar, fkVar);
        nativeSetCallback(j);
        AppMethodBeat.o(98013);
    }

    public void destory() {
        AppMethodBeat.i(98014);
        this.a.a();
        this.a = null;
        AppMethodBeat.o(98014);
    }

    public void setHeatTileLoadCallback(d dVar) {
        AppMethodBeat.i(98015);
        if (this.a != null) {
            this.a.a(dVar);
        }
        AppMethodBeat.o(98015);
    }

    public void setWorldTileLoadCallback(j jVar) {
        AppMethodBeat.i(98016);
        if (this.a != null) {
            this.a.a(jVar);
        }
        AppMethodBeat.o(98016);
    }

    public void setHandDrawTileLoadCallback(b bVar) {
        AppMethodBeat.i(98017);
        if (this.a != null) {
            this.a.a(bVar);
        }
        AppMethodBeat.o(98017);
    }

    public void setHandDrawTileWriteCallback(c cVar) {
        AppMethodBeat.i(98018);
        if (this.a != null) {
            this.a.a(cVar);
        }
        AppMethodBeat.o(98018);
    }

    public void setTileWriteCallback(k kVar) {
        AppMethodBeat.i(98019);
        if (this.a != null) {
            this.a.a(kVar);
        }
        AppMethodBeat.o(98019);
    }

    public void setMapCallbackGetGLContext(f fVar) {
        AppMethodBeat.i(98020);
        if (this.a != null) {
            this.a.a(fVar);
        }
        AppMethodBeat.o(98020);
    }

    public Object callback(int i, int i2, String str, byte[] bArr) {
        AppMethodBeat.i(98021);
        Object a = this.a.a(i, i2, str, bArr);
        AppMethodBeat.o(98021);
        return a;
    }

    public int callbackGetGLContext() {
        AppMethodBeat.i(98022);
        int b = this.a.b();
        AppMethodBeat.o(98022);
        return b;
    }
}
