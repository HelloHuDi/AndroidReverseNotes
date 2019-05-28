package com.tencent.ttpic.model;

import java.util.List;

public class FaceExpression {
    public String audioID;
    public List<CanvasItem> canvasItemList;
    public int canvasResizeMode;
    public SizeI canvasSize;
    public List<ExpressionItem> expressionList;
    public int expressionNumber;
    public double frameDuration;
    public int frames;
    public String id;
    public String scoreImageID;
    public String videoID;
}
