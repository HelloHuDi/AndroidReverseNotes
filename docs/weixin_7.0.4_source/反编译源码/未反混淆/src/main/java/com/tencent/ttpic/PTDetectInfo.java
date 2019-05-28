package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo {
    public List<PointF> bodyPoints;
    public Map<Integer, FaceActionCounter> faceActionCounter;
    public float[] faceAngles;
    public VideoPreviewFaceOutlineDetector faceDetector;
    public List<PointF> facePoints;
    public Map<Integer, HandActionCounter> handActionCounter;
    public List<PointF> handPoints;
    public float phoneAngle;
    public long timestamp;
    public Set<Integer> triggeredExpression;

    public static class Builder {
        private List<PointF> bodyPoints;
        private Map<Integer, FaceActionCounter> faceActionCounter;
        private float[] faceAngles;
        private VideoPreviewFaceOutlineDetector faceDetector;
        private List<PointF> facePoints;
        private Map<Integer, HandActionCounter> handActionCounter;
        private List<PointF> handPoints;
        private float phoneAngle;
        private long timestamp;
        private Set<Integer> triggeredExpression;

        public Builder facePoints(List<PointF> list) {
            this.facePoints = list;
            return this;
        }

        public Builder faceAngles(float[] fArr) {
            this.faceAngles = fArr;
            return this;
        }

        public Builder faceActionCounter(Map<Integer, FaceActionCounter> map) {
            this.faceActionCounter = map;
            return this;
        }

        public Builder handPoints(List<PointF> list) {
            this.handPoints = list;
            return this;
        }

        public Builder handActionCounter(Map<Integer, HandActionCounter> map) {
            this.handActionCounter = map;
            return this;
        }

        public Builder triggeredExpression(Set<Integer> set) {
            this.triggeredExpression = set;
            return this;
        }

        public Builder bodyPoints(List<PointF> list) {
            this.bodyPoints = list;
            return this;
        }

        public Builder phoneAngle(float f) {
            this.phoneAngle = f;
            return this;
        }

        public Builder timestamp(long j) {
            this.timestamp = j;
            return this;
        }

        public Builder faceDetector(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
            this.faceDetector = videoPreviewFaceOutlineDetector;
            return this;
        }

        public PTDetectInfo build() {
            AppMethodBeat.i(81563);
            PTDetectInfo pTDetectInfo = new PTDetectInfo(this);
            AppMethodBeat.o(81563);
            return pTDetectInfo;
        }
    }

    private PTDetectInfo() {
    }

    public PTDetectInfo(Builder builder) {
        AppMethodBeat.i(81564);
        this.facePoints = builder.facePoints;
        this.faceAngles = builder.faceAngles;
        this.faceActionCounter = builder.faceActionCounter;
        this.handPoints = builder.handPoints;
        this.handActionCounter = builder.handActionCounter;
        this.triggeredExpression = builder.triggeredExpression;
        this.bodyPoints = builder.bodyPoints;
        this.phoneAngle = builder.phoneAngle;
        this.timestamp = builder.timestamp;
        this.faceDetector = builder.faceDetector;
        AppMethodBeat.o(81564);
    }
}
