package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25625a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransformFilter extends VideoFilterBase {
    private static final List<DistortionItem> EMPTY = new ArrayList();
    private static final int MESH_DISTORTION_TYPE_COUNT = 30;
    private static final int XCOORD_NUM = 50;
    private static final int YCOORD_NUM = 66;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, -1.0f, 1.0f, -1.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, 0.0f, 1.0f, 0.0f, 1.0f);
    float anotherStrength;
    private String dataPath;
    private float faceHeight;
    private float faceWidth;
    private float[] flatMesh;
    private List<DistortionItem> items;
    private FaceMeshItem mFaceMeshItem;
    private int mLastMeshIndex;
    private Map<String, List<DistortionItem>> mMeshCache;
    private MeshDistortionType[] meshs;
    private boolean optimizeBoundary;
    private float optimizeBoundaryStrength;
    private float screenRatioX;
    private float screenRatioY;
    private List<StickerItem> stickerItems;
    private TriggerCtrlItem triggerCtrlItem;

    static {
        AppMethodBeat.m2504i(83037);
        AppMethodBeat.m2505o(83037);
    }

    public TransformFilter(List<DistortionItem> list, List<StickerItem> list2) {
        super(PROGRAM_TYPE.TRANSFORM);
        AppMethodBeat.m2504i(83021);
        this.meshs = new MeshDistortionType[30];
        this.flatMesh = new float[210];
        this.mLastMeshIndex = -1;
        this.mMeshCache = new HashMap();
        this.optimizeBoundary = true;
        this.optimizeBoundaryStrength = 0.25f;
        this.screenRatioX = 1.0f;
        this.screenRatioY = 1.0f;
        this.anotherStrength = 1.0f;
        this.items = list;
        this.stickerItems = list2;
        this.triggerCtrlItem = new TriggerCtrlItem();
        initParams();
        AppMethodBeat.m2505o(83021);
    }

    public TransformFilter(FaceMeshItem faceMeshItem, String str) {
        super(PROGRAM_TYPE.TRANSFORM);
        AppMethodBeat.m2504i(83022);
        this.meshs = new MeshDistortionType[30];
        this.flatMesh = new float[210];
        this.mLastMeshIndex = -1;
        this.mMeshCache = new HashMap();
        this.optimizeBoundary = true;
        this.optimizeBoundaryStrength = 0.25f;
        this.screenRatioX = 1.0f;
        this.screenRatioY = 1.0f;
        this.anotherStrength = 1.0f;
        this.mFaceMeshItem = faceMeshItem;
        this.dataPath = str;
        this.items = EMPTY;
        this.triggerCtrlItem = new TriggerCtrlItem(this.mFaceMeshItem);
        initParams();
        AppMethodBeat.m2505o(83022);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(83023);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(6651);
        AppMethodBeat.m2505o(83023);
    }

    public void initParams() {
        AppMethodBeat.m2504i(83024);
        addParam(new C0933f("screenRatioX", 0.0f));
        addParam(new C0933f("screenRatioY", 0.0f));
        addParam(new C25625a("item", this.flatMesh));
        addParam(new C0933f("faceRatio", 1.0f));
        addParam(new C0933f("sin_roll", 0.0f));
        addParam(new C0933f("cos_roll", 0.0f));
        addParam(new C0933f("tan_yaw", 0.0f));
        addParam(new C0933f("cos_yaw", 0.0f));
        addParam(new C0933f("tan_pitch", 0.0f));
        addParam(new C0933f("cos_pitch", 0.0f));
        for (int i = 0; i < 30; i++) {
            this.meshs[i] = new MeshDistortionType();
        }
        AppMethodBeat.m2505o(83024);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(83025);
        float[] fArr = pTDetectInfo.faceAngles;
        if (pTDetectInfo.phoneAngle == 90.0f || pTDetectInfo.phoneAngle == 270.0f) {
            fArr = new float[]{-pTDetectInfo.faceAngles[1], -pTDetectInfo.faceAngles[0], pTDetectInfo.faceAngles[2]};
        }
        if (this.dataPath != null) {
            updateActionTriggered(pTDetectInfo.triggeredExpression, pTDetectInfo.timestamp);
            if (this.triggerCtrlItem.isTriggered()) {
                updateMeshParam();
            } else {
                this.items = EMPTY;
                this.mLastMeshIndex = -1;
            }
        }
        updateParams(pTDetectInfo.facePoints, pTDetectInfo.triggeredExpression, this.mFaceDetScale, fArr);
        AppMethodBeat.m2505o(83025);
    }

    private TRIGGERED_STATUS updateActionTriggered(Set<Integer> set, long j) {
        AppMethodBeat.m2504i(83026);
        TRIGGERED_STATUS triggeredStatus = this.triggerCtrlItem.getTriggeredStatus(new Builder().triggeredExpression(set).timestamp(j).build());
        AppMethodBeat.m2505o(83026);
        return triggeredStatus;
    }

    private void updateMeshParam() {
        AppMethodBeat.m2504i(83027);
        int frameIndex = this.triggerCtrlItem.getFrameIndex();
        if (frameIndex == this.mLastMeshIndex) {
            AppMethodBeat.m2505o(83027);
            return;
        }
        this.items = getNextFrame(frameIndex);
        this.mLastMeshIndex = frameIndex;
        AppMethodBeat.m2505o(83027);
    }

    private List<DistortionItem> getNextFrame(int i) {
        AppMethodBeat.m2504i(83028);
        String str = this.mFaceMeshItem.f14331id + "_" + i;
        if (!this.mMeshCache.containsKey(str)) {
            ArrayList arrayList = new ArrayList();
            String load = FileUtils.load(VideoGlobalContext.getContext(), this.dataPath + "/" + this.mFaceMeshItem.f14331id, str + ".json");
            if (!TextUtils.isEmpty(load)) {
                try {
                    JSONArray optJSONArray = new JSONObject(load).optJSONArray(FIELD.DISTORTION_LIST.value);
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            DistortionItem distortionItem = new DistortionItem();
                            JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                            distortionItem.position = jSONObject.optInt(DISTORTION_ITEM_FILED.POSITION.value);
                            distortionItem.distortion = jSONObject.optInt(DISTORTION_ITEM_FILED.DISTORTION.value);
                            distortionItem.direction = jSONObject.optInt(DISTORTION_ITEM_FILED.DIRECTION.value);
                            distortionItem.radius = (float) jSONObject.optDouble(DISTORTION_ITEM_FILED.RADIUS.value);
                            distortionItem.strength = (float) jSONObject.optDouble(DISTORTION_ITEM_FILED.STRENGH.value);
                            distortionItem.f18267x = jSONObject.optInt(DISTORTION_ITEM_FILED.X.value);
                            distortionItem.f18268y = jSONObject.optInt(DISTORTION_ITEM_FILED.Y.value);
                            arrayList.add(distortionItem);
                        }
                    }
                } catch (JSONException e) {
                }
            }
            this.mMeshCache.put(str, arrayList);
        }
        List list = (List) this.mMeshCache.get(str);
        AppMethodBeat.m2505o(83028);
        return list;
    }

    public void updateParams(List<PointF> list, Set<Integer> set, double d, float[] fArr) {
        AppMethodBeat.m2504i(83029);
        List copyList = VideoMaterialUtil.copyList(list);
        Arrays.fill(this.flatMesh, -1.0f);
        if (!(copyList == null || copyList.size() < 90 || BaseUtils.isEmpty(this.items))) {
            if (VideoFilterUtil.actionTriggered(list, this.stickerItems, set)) {
                int i;
                List fullPoints = TransformUtil.getFullPoints(copyList);
                float f = ((PointF) fullPoints.get(18)).x - ((PointF) fullPoints.get(0)).x;
                float f2 = ((PointF) fullPoints.get(18)).y - ((PointF) fullPoints.get(0)).y;
                float f3 = ((PointF) fullPoints.get(9)).x - ((PointF) fullPoints.get(89)).x;
                float f4 = ((PointF) fullPoints.get(9)).y - ((PointF) fullPoints.get(89)).y;
                this.faceWidth = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
                this.faceHeight = (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
                f3 = this.faceHeight / this.faceWidth;
                float atan2 = (float) (Math.atan2((double) (((PointF) fullPoints.get(9)).x - ((PointF) fullPoints.get(84)).x), (double) (((PointF) fullPoints.get(84)).y + (-((PointF) fullPoints.get(9)).y))) + 3.141592653589793d);
                PointF pointF = new PointF((float) (((((double) (((PointF) fullPoints.get(9)).x * 2.0f)) / d) / ((double) this.width)) - 1.0d), (((float) (((((double) (((PointF) fullPoints.get(9)).y * 2.0f)) / d) / ((double) this.height)) - 1.0d)) * ((float) this.height)) / ((float) this.width));
                PointF pointF2 = new PointF((float) (((((double) (((PointF) fullPoints.get(89)).x * 2.0f)) / d) / ((double) this.width)) - 1.0d), (((float) (((((double) (((PointF) fullPoints.get(89)).y * 2.0f)) / d) / ((double) this.height)) - 1.0d)) * ((float) this.height)) / ((float) this.width));
                float distance = AlgoUtils.getDistance(pointF, pointF2);
                float min = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr[1]) * 1.5d));
                float tan = (float) Math.tan((double) min);
                float cos = (float) Math.cos((double) min);
                PointF pointF3 = new PointF(((PointF) fullPoints.get(43)).x + ((((PointF) fullPoints.get(9)).x - ((PointF) fullPoints.get(43)).x) / 3.0f), ((((PointF) fullPoints.get(9)).y - ((PointF) fullPoints.get(43)).y) / 3.0f) + ((PointF) fullPoints.get(43)).y);
                pointF3.x = (float) (((((double) (2.0f * pointF3.x)) / d) / ((double) this.width)) - 1.0d);
                pointF3.y = (((float) (((((double) (2.0f * pointF3.y)) / d) / ((double) this.height)) - 1.0d)) * ((float) this.height)) / ((float) this.width);
                pointF3 = new PointF(((PointF) fullPoints.get(53)).x + ((((PointF) fullPoints.get(9)).x - ((PointF) fullPoints.get(53)).x) / 3.0f), ((((PointF) fullPoints.get(9)).y - ((PointF) fullPoints.get(53)).y) / 3.0f) + ((PointF) fullPoints.get(53)).y);
                pointF3.x = (float) (((((double) (2.0f * pointF3.x)) / d) / ((double) this.width)) - 1.0d);
                pointF3.y = (((float) (((((double) (2.0f * pointF3.y)) / d) / ((double) this.height)) - 1.0d)) * ((float) this.height)) / ((float) this.width);
                float distance2 = AlgoUtils.getDistance(pointF3, pointF3);
                float min2 = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr[0]) * 1.4d));
                Math.tan((double) min2);
                float cos2 = (float) Math.cos((double) min2);
                float cos3 = (float) Math.cos((double) atan2);
                float sin = (float) Math.sin((double) atan2);
                int size = fullPoints.size();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= this.items.size()) {
                        break;
                    }
                    DistortionItem distortionItem = (DistortionItem) this.items.get(i);
                    this.meshs[i].type = distortionItem.distortion;
                    if (distortionItem.position < size) {
                        this.meshs[i].point = (PointF) fullPoints.get(distortionItem.position);
                    }
                    f = getStrengthAdjust(i);
                    this.meshs[i].strength = f * distortionItem.strength;
                    this.meshs[i].radius = (float) (((((double) (distortionItem.radius * this.faceWidth)) / d) / ((double) Math.min(this.width, this.height))) / 375.0d);
                    f = ((float) distortionItem.f18267x) * cos;
                    float f5 = ((float) distortionItem.f18268y) * cos2;
                    this.meshs[i].offsetX = (((f * cos3) + (f5 * sin)) * this.faceWidth) / 375.0f;
                    this.meshs[i].offsetY = (((f * sin) - (f5 * cos3)) * this.faceWidth) / 375.0f;
                    this.meshs[i].direction = (float) distortionItem.direction;
                    if (distortionItem.distortion == 4 || distortionItem.distortion == 5) {
                        PointF pointF4 = (PointF) fullPoints.get(distortionItem.direction);
                        f5 = ((((((float) distortionItem.targetDx) * cos3) * cos) + ((((float) distortionItem.targetDy) * sin) * cos2)) * this.faceWidth) / 375.0f;
                        float f6 = ((((((float) distortionItem.targetDx) * sin) * cos) - ((((float) distortionItem.targetDy) * cos3) * cos2)) * this.faceWidth) / 375.0f;
                        this.meshs[i].direction = (float) Math.atan2((double) (((f6 + pointF4.y) - this.meshs[i].point.y) - this.meshs[i].offsetY), (double) (((pointF4.x + f5) - this.meshs[i].point.x) - this.meshs[i].offsetX));
                        if (distortionItem.distortion == 5) {
                            this.meshs[i].direction = 3.1415927f + this.meshs[i].direction;
                        }
                    }
                    this.meshs[i].faceDegree = atan2;
                    this.meshs[i].faceRatio = f3;
                    i2 = i + 1;
                }
                for (i2 = this.items.size(); i2 < 30; i2++) {
                    this.meshs[i2].type = -1;
                }
                int i3 = 0;
                for (i2 = 0; i2 < this.items.size(); i2++) {
                    int i4 = i3 + 1;
                    this.flatMesh[i3] = (float) this.meshs[i2].type;
                    i = i4 + 1;
                    this.flatMesh[i4] = this.meshs[i2].strength;
                    float f7 = (float) (((((double) (2.0f * (this.meshs[i2].point.x + this.meshs[i2].offsetX))) / d) / ((double) this.width)) - 1.0d);
                    cos = (float) (((((double) (2.0f * (this.meshs[i2].point.y + this.meshs[i2].offsetY))) / d) / ((double) this.height)) - 1.0d);
                    int i5 = i + 1;
                    this.flatMesh[i] = this.screenRatioX * f7;
                    i = i5 + 1;
                    this.flatMesh[i5] = this.screenRatioY * cos;
                    f = AlgoUtils.distanceOfPoint2Line(pointF, pointF2, distance, new PointF(f7, (((float) this.height) * cos) / ((float) this.width))) * tan;
                    if (((pointF.x - pointF2.x) * (cos - pointF2.y)) - ((pointF.y - pointF2.y) * (f7 - pointF2.x)) > 0.0f) {
                        f = -f;
                    }
                    AlgoUtils.distanceOfPoint2Line(pointF3, pointF3, distance2, new PointF(f7, (cos * ((float) this.height)) / ((float) this.width)));
                    f7 = pointF3.x;
                    f7 = pointF3.x;
                    f7 = pointF3.y;
                    f7 = pointF3.y;
                    f7 = pointF3.y;
                    f7 = pointF3.x;
                    f7 = 2.5f + f;
                    this.meshs[i2].radius = (this.meshs[i2].radius * 2.5f) / f7;
                    int i6 = i + 1;
                    this.flatMesh[i] = this.meshs[i2].radius;
                    i = i6 + 1;
                    this.flatMesh[i6] = this.meshs[i2].direction;
                    i3 = i + 1;
                    this.flatMesh[i] = f7;
                }
                addParam(new C0933f("faceRatio", f3));
                addParam(new C0933f("sin_roll", (float) Math.sin((double) atan2)));
                addParam(new C0933f("cos_roll", (float) Math.cos((double) atan2)));
                addParam(new C0933f("tan_yaw", (float) Math.tan((double) min)));
                addParam(new C0933f("cos_yaw", (float) Math.cos((double) min)));
                addParam(new C0933f("tan_pitch", (float) Math.tan((double) min2)));
                addParam(new C0933f("cos_pitch", (float) Math.cos((double) min2)));
                addParam(new C25625a("item", this.flatMesh));
                AppMethodBeat.m2505o(83029);
            }
        }
        addParam(new C0933f("faceRatio", 1.0f));
        addParam(new C25625a("item", this.flatMesh));
        AppMethodBeat.m2505o(83029);
    }

    public void updateFaceFeatures(List<PointF> list) {
        AppMethodBeat.m2504i(83030);
        if (list == null || list.size() < 131) {
            AppMethodBeat.m2505o(83030);
            return;
        }
        float f = ((PointF) list.get(18)).x - ((PointF) list.get(0)).x;
        float f2 = ((PointF) list.get(18)).y - ((PointF) list.get(0)).y;
        float f3 = ((PointF) list.get(9)).x - ((PointF) list.get(89)).x;
        float f4 = ((PointF) list.get(9)).y - ((PointF) list.get(89)).y;
        this.faceWidth = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        this.faceHeight = (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
        f2 = this.faceHeight / this.faceWidth;
        f3 = (float) (Math.atan2((double) (((PointF) list.get(9)).x - ((PointF) list.get(84)).x), (double) (((PointF) list.get(84)).y + (-((PointF) list.get(9)).y))) + 3.141592653589793d);
        float f5 = ((float) this.height) / ((float) this.width);
        float f6 = (float) (2.0d / (((double) this.width) * this.mFaceDetScale));
        float f7 = (float) (2.0d / (((double) this.height) * this.mFaceDetScale));
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        PointF pointF3 = new PointF();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 131) {
                if (i2 < 99 || i2 > 106) {
                    pointF.x = (((PointF) list.get(i2)).x * f6) - 1.0f;
                    pointF.y = (((PointF) list.get(i2)).y * f7) - 1.0f;
                    for (i = 0; i < this.meshs.length; i++) {
                        if (this.meshs[i].type > 0) {
                            pointF2.x = ((this.meshs[i].point.x + this.meshs[i].offsetX) * f6) - 1.0f;
                            pointF2.y = (((this.meshs[i].point.y + this.meshs[i].offsetY) * f7) - 1.0f) * f5;
                            pointF3.x = pointF.x;
                            pointF3.y = pointF.y * f5;
                            float distance = AlgoUtils.getDistance(pointF2, pointF3);
                            if (distance < this.meshs[i].radius) {
                                distance /= this.meshs[i].radius;
                                float f8 = pointF2.x - pointF3.x;
                                float f9 = (pointF2.y - pointF3.y) / f5;
                                if (this.meshs[i].type == 1) {
                                    distance = (float) ((1.5d * (1.0d - Math.sin((((double) distance) * 3.1415d) * 0.5d))) * ((double) this.meshs[i].strength));
                                    pointF.x -= f8 * distance;
                                    pointF.y -= distance * f9;
                                } else if (this.meshs[i].type == 2) {
                                    distance = (float) (Math.cos(1.57075d * ((double) distance)) * ((double) this.meshs[i].strength));
                                    pointF.x = (f8 * distance) + pointF.x;
                                    pointF.y = (distance * f9) + pointF.y;
                                } else if (this.meshs[i].type == 3) {
                                    distance = (float) ((((Math.cos(((double) distance) * 1.57075d) * ((double) this.meshs[i].radius)) * 0.5d) / ((double) f2)) * ((double) this.meshs[i].strength));
                                    PointF pointF4 = new PointF(f2, f2 / f5);
                                    if (this.meshs[i].direction == 1.0f) {
                                        pointF4.x = (-distance) * pointF4.x;
                                        pointF4.y = 0.0f;
                                    } else if (this.meshs[i].direction == 2.0f) {
                                        pointF4.x = 0.0f;
                                        pointF4.y = (-distance) * pointF4.y;
                                    } else if (this.meshs[i].direction == 3.0f) {
                                        pointF4.x = distance * pointF4.x;
                                        pointF4.y = 0.0f;
                                    } else if (this.meshs[i].direction == 4.0f) {
                                        pointF4.x = 0.0f;
                                        pointF4.y = distance * pointF4.y;
                                    } else if (this.meshs[i].direction == 5.0f) {
                                        pointF4.x *= -distance;
                                        pointF4.y = (-distance) * pointF4.y;
                                    } else if (this.meshs[i].direction == 6.0f) {
                                        pointF4.x *= distance;
                                        pointF4.y = (-distance) * pointF4.y;
                                    } else if (this.meshs[i].direction == 7.0f) {
                                        pointF4.x *= -distance;
                                        pointF4.y = distance * pointF4.y;
                                    } else if (this.meshs[i].direction == 8.0f) {
                                        pointF4.x *= distance;
                                        pointF4.y = distance * pointF4.y;
                                    } else {
                                        pointF4.x = 0.0f;
                                        pointF4.y = 0.0f;
                                    }
                                    pointF.x = (float) (((double) pointF.x) + ((((double) pointF4.x) * Math.cos((double) f3)) - (((double) pointF4.y) * Math.sin((double) f3))));
                                    pointF.y = (float) ((((((double) pointF4.x) * Math.sin((double) f3)) + (((double) pointF4.y) * Math.cos((double) f3))) / ((double) f5)) + ((double) pointF.y));
                                }
                            }
                        }
                    }
                    ((PointF) list.get(i2)).x = (pointF.x + 1.0f) / f6;
                    ((PointF) list.get(i2)).y = (pointF.y + 1.0f) / f7;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(83030);
                return;
            }
        }
    }

    private float getStrengthAdjust(int i) {
        float f;
        AppMethodBeat.m2504i(83031);
        if ("OPPO_X909".equals(DeviceInstance.getInstance().getDeviceName())) {
            f = 0.2f;
        } else {
            f = 1.0f;
        }
        if (this.optimizeBoundary && this.faceWidth > 0.0f && this.width > 0 && this.mFaceDetScale > 0.0d) {
            float f2 = this.faceWidth * this.optimizeBoundaryStrength;
            float f3 = ((float) this.width) * ((float) this.mFaceDetScale);
            float f4 = ((float) this.height) * ((float) this.mFaceDetScale);
            float min = Math.min(f3, f4);
            f2 = Math.min(0.15f * min, Math.min(f2, min * this.meshs[i].radius));
            f *= (Math.min(Math.min(Math.min(1.0f, Math.max(0.0f, (this.meshs[i].point.x + this.meshs[i].offsetX) / f2)), Math.min(1.0f, Math.max(0.0f, ((f3 - this.meshs[i].point.x) - this.meshs[i].offsetX) / f2))), Math.min(Math.min(1.0f, Math.max(0.0f, (this.meshs[i].point.y + this.meshs[i].offsetY) / f2)), Math.min(1.0f, Math.max(0.0f, ((f4 - this.meshs[i].point.y) - this.meshs[i].offsetY) / f2)))) * 0.9f) + 0.100000024f;
        }
        AppMethodBeat.m2505o(83031);
        return f;
    }

    public void updateStrength(float f) {
        this.anotherStrength = f;
    }

    public void updateVideoSize(int i, int i2, double d) {
        float f = 1.0f;
        AppMethodBeat.m2504i(83032);
        super.updateVideoSize(i, i2, d);
        float f2 = ((float) this.height) / ((float) this.width);
        this.screenRatioX = f2 > 1.0f ? 1.0f : 1.0f / f2;
        if (f2 > 1.0f) {
            f = f2;
        }
        this.screenRatioY = f;
        addParam(new C0933f("screenRatioX", this.screenRatioX));
        addParam(new C0933f("screenRatioY", this.screenRatioY));
        AppMethodBeat.m2505o(83032);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(83033);
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(83033);
    }

    public void setDistortionItems(List<DistortionItem> list) {
        this.items = list;
    }

    public void reset() {
        AppMethodBeat.m2504i(83034);
        this.triggerCtrlItem.reset();
        AppMethodBeat.m2505o(83034);
    }

    public void setRenderForBitmap(boolean z) {
        AppMethodBeat.m2504i(83035);
        this.triggerCtrlItem.setRenderForBitmap(z);
        AppMethodBeat.m2505o(83035);
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.m2504i(83036);
        this.triggerCtrlItem.setTriggerWords(str);
        AppMethodBeat.m2505o(83036);
    }

    public FaceMeshItem getFaceMeshItem() {
        return this.mFaceMeshItem;
    }

    public void setOptimizeBoundary(boolean z) {
        this.optimizeBoundary = z;
    }
}
