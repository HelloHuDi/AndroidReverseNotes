.class La/b/b/a/k$f;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "f"
.end annotation


# static fields
.field private static final a:Landroid/graphics/Matrix;


# instance fields
.field private final b:Landroid/graphics/Path;

.field private final c:Landroid/graphics/Path;

.field private final d:Landroid/graphics/Matrix;

.field e:Landroid/graphics/Paint;

.field f:Landroid/graphics/Paint;

.field private g:Landroid/graphics/PathMeasure;

.field private h:I

.field final i:La/b/b/a/k$c;

.field j:F

.field k:F

.field l:F

.field m:F

.field n:I

.field o:Ljava/lang/String;

.field p:Ljava/lang/Boolean;

.field final q:La/b/c/f/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/b<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1161
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    sput-object v0, La/b/b/a/k$f;->a:Landroid/graphics/Matrix;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1182
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1162
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    .line 1172
    const/4 v0, 0x0

    iput v0, p0, La/b/b/a/k$f;->j:F

    .line 1173
    iput v0, p0, La/b/b/a/k$f;->k:F

    .line 1174
    iput v0, p0, La/b/b/a/k$f;->l:F

    .line 1175
    iput v0, p0, La/b/b/a/k$f;->m:F

    .line 1176
    const/16 v0, 0xff

    iput v0, p0, La/b/b/a/k$f;->n:I

    .line 1177
    const/4 v0, 0x0

    iput-object v0, p0, La/b/b/a/k$f;->o:Ljava/lang/String;

    .line 1178
    iput-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    .line 1180
    new-instance v0, La/b/c/f/b;

    invoke-direct {v0}, La/b/c/f/b;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->q:La/b/c/f/b;

    .line 1183
    new-instance v0, La/b/b/a/k$c;

    invoke-direct {v0}, La/b/b/a/k$c;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    .line 1184
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    .line 1185
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    .line 1186
    return-void
.end method

.method public constructor <init>(La/b/b/a/k$f;)V
    .locals 3
    .param p1, "copy"    # La/b/b/a/k$f;

    .line 1207
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1162
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    .line 1172
    const/4 v0, 0x0

    iput v0, p0, La/b/b/a/k$f;->j:F

    .line 1173
    iput v0, p0, La/b/b/a/k$f;->k:F

    .line 1174
    iput v0, p0, La/b/b/a/k$f;->l:F

    .line 1175
    iput v0, p0, La/b/b/a/k$f;->m:F

    .line 1176
    const/16 v0, 0xff

    iput v0, p0, La/b/b/a/k$f;->n:I

    .line 1177
    const/4 v0, 0x0

    iput-object v0, p0, La/b/b/a/k$f;->o:Ljava/lang/String;

    .line 1178
    iput-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    .line 1180
    new-instance v0, La/b/c/f/b;

    invoke-direct {v0}, La/b/c/f/b;-><init>()V

    iput-object v0, p0, La/b/b/a/k$f;->q:La/b/c/f/b;

    .line 1208
    new-instance v0, La/b/b/a/k$c;

    iget-object v1, p1, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    iget-object v2, p0, La/b/b/a/k$f;->q:La/b/c/f/b;

    invoke-direct {v0, v1, v2}, La/b/b/a/k$c;-><init>(La/b/b/a/k$c;La/b/c/f/b;)V

    iput-object v0, p0, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    .line 1209
    new-instance v0, Landroid/graphics/Path;

    iget-object v1, p1, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    invoke-direct {v0, v1}, Landroid/graphics/Path;-><init>(Landroid/graphics/Path;)V

    iput-object v0, p0, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    .line 1210
    new-instance v0, Landroid/graphics/Path;

    iget-object v1, p1, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    invoke-direct {v0, v1}, Landroid/graphics/Path;-><init>(Landroid/graphics/Path;)V

    iput-object v0, p0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    .line 1211
    iget v0, p1, La/b/b/a/k$f;->j:F

    iput v0, p0, La/b/b/a/k$f;->j:F

    .line 1212
    iget v0, p1, La/b/b/a/k$f;->k:F

    iput v0, p0, La/b/b/a/k$f;->k:F

    .line 1213
    iget v0, p1, La/b/b/a/k$f;->l:F

    iput v0, p0, La/b/b/a/k$f;->l:F

    .line 1214
    iget v0, p1, La/b/b/a/k$f;->m:F

    iput v0, p0, La/b/b/a/k$f;->m:F

    .line 1215
    iget v0, p1, La/b/b/a/k$f;->h:I

    iput v0, p0, La/b/b/a/k$f;->h:I

    .line 1216
    iget v0, p1, La/b/b/a/k$f;->n:I

    iput v0, p0, La/b/b/a/k$f;->n:I

    .line 1217
    iget-object v0, p1, La/b/b/a/k$f;->o:Ljava/lang/String;

    iput-object v0, p0, La/b/b/a/k$f;->o:Ljava/lang/String;

    .line 1218
    iget-object v0, p1, La/b/b/a/k$f;->o:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 1219
    iget-object v1, p0, La/b/b/a/k$f;->q:La/b/c/f/b;

    invoke-virtual {v1, v0, p0}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1221
    :cond_0
    iget-object v0, p1, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    iput-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    .line 1222
    return-void
.end method

.method private static a(FFFF)F
    .locals 2
    .param p0, "v1x"    # F
    .param p1, "v1y"    # F
    .param p2, "v2x"    # F
    .param p3, "v2y"    # F

    .line 1364
    mul-float v0, p0, p3

    mul-float v1, p1, p2

    sub-float/2addr v0, v1

    return v0
.end method

.method private a(Landroid/graphics/Matrix;)F
    .locals 10
    .param p1, "groupStackedMatrix"    # Landroid/graphics/Matrix;

    .line 1378
    const/4 v0, 0x4

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    .line 1379
    .local v0, "unitVectors":[F
    invoke-virtual {p1, v0}, Landroid/graphics/Matrix;->mapVectors([F)V

    .line 1380
    const/4 v1, 0x0

    aget v2, v0, v1

    float-to-double v2, v2

    const/4 v4, 0x1

    aget v5, v0, v4

    float-to-double v5, v5

    invoke-static {v2, v3, v5, v6}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v2

    double-to-float v2, v2

    .line 1381
    .local v2, "scaleX":F
    const/4 v3, 0x2

    aget v5, v0, v3

    float-to-double v5, v5

    const/4 v7, 0x3

    aget v8, v0, v7

    float-to-double v8, v8

    invoke-static {v5, v6, v8, v9}, Ljava/lang/Math;->hypot(DD)D

    move-result-wide v5

    double-to-float v5, v5

    .line 1382
    .local v5, "scaleY":F
    aget v1, v0, v1

    aget v4, v0, v4

    aget v3, v0, v3

    aget v6, v0, v7

    invoke-static {v1, v4, v3, v6}, La/b/b/a/k$f;->a(FFFF)F

    move-result v1

    .line 1384
    .local v1, "crossProduct":F
    invoke-static {v2, v5}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1386
    .local v3, "maxScale":F
    const/4 v4, 0x0

    .line 1387
    .local v4, "matrixScale":F
    const/4 v6, 0x0

    cmpl-float v6, v3, v6

    if-lez v6, :cond_0

    .line 1388
    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v6

    div-float v4, v6, v3

    .line 1393
    :cond_0
    return v4

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method private a(La/b/b/a/k$c;La/b/b/a/k$e;Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V
    .locals 18
    .param p1, "vGroup"    # La/b/b/a/k$c;
    .param p2, "vPath"    # La/b/b/a/k$e;
    .param p3, "canvas"    # Landroid/graphics/Canvas;
    .param p4, "w"    # I
    .param p5, "h"    # I
    .param p6, "filter"    # Landroid/graphics/ColorFilter;

    .line 1260
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p6

    move/from16 v4, p4

    int-to-float v5, v4

    iget v6, v0, La/b/b/a/k$f;->l:F

    div-float/2addr v5, v6

    .line 1261
    .local v5, "scaleX":F
    move/from16 v6, p5

    int-to-float v7, v6

    iget v8, v0, La/b/b/a/k$f;->m:F

    div-float/2addr v7, v8

    .line 1262
    .local v7, "scaleY":F
    invoke-static {v5, v7}, Ljava/lang/Math;->min(FF)F

    move-result v8

    .line 1263
    .local v8, "minScale":F
    move-object/from16 v9, p1

    iget-object v10, v9, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    .line 1265
    .local v10, "groupStackedMatrix":Landroid/graphics/Matrix;
    iget-object v11, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v11, v10}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 1266
    iget-object v11, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v11, v5, v7}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 1269
    invoke-direct {v0, v10}, La/b/b/a/k$f;->a(Landroid/graphics/Matrix;)F

    move-result v11

    .line 1270
    .local v11, "matrixScale":F
    const/4 v12, 0x0

    cmpl-float v13, v11, v12

    if-nez v13, :cond_0

    .line 1272
    return-void

    .line 1274
    :cond_0
    iget-object v13, v0, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    invoke-virtual {v1, v13}, La/b/b/a/k$e;->a(Landroid/graphics/Path;)V

    .line 1275
    iget-object v13, v0, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    .line 1277
    .local v13, "path":Landroid/graphics/Path;
    iget-object v14, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    invoke-virtual {v14}, Landroid/graphics/Path;->reset()V

    .line 1279
    invoke-virtual/range {p2 .. p2}, La/b/b/a/k$e;->b()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 1280
    iget-object v12, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    iget-object v14, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v12, v13, v14}, Landroid/graphics/Path;->addPath(Landroid/graphics/Path;Landroid/graphics/Matrix;)V

    .line 1281
    iget-object v12, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    invoke-virtual {v2, v12}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z

    move/from16 v16, v5

    goto/16 :goto_6

    .line 1283
    :cond_1
    move-object v14, v1

    check-cast v14, La/b/b/a/k$b;

    .line 1284
    .local v14, "fullPath":La/b/b/a/k$b;
    iget v15, v14, La/b/b/a/k$b;->k:F

    const/high16 v16, 0x3f800000    # 1.0f

    cmpl-float v15, v15, v12

    if-nez v15, :cond_3

    iget v15, v14, La/b/b/a/k$b;->l:F

    cmpl-float v15, v15, v16

    if-eqz v15, :cond_2

    goto :goto_0

    :cond_2
    move/from16 v16, v5

    goto :goto_2

    .line 1285
    :cond_3
    :goto_0
    iget v15, v14, La/b/b/a/k$b;->k:F

    iget v12, v14, La/b/b/a/k$b;->m:F

    add-float/2addr v15, v12

    rem-float v15, v15, v16

    .line 1286
    .local v15, "start":F
    iget v1, v14, La/b/b/a/k$b;->l:F

    add-float/2addr v1, v12

    rem-float v1, v1, v16

    .line 1288
    .local v1, "end":F
    iget-object v12, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    if-nez v12, :cond_4

    .line 1289
    new-instance v12, Landroid/graphics/PathMeasure;

    invoke-direct {v12}, Landroid/graphics/PathMeasure;-><init>()V

    iput-object v12, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    .line 1291
    :cond_4
    iget-object v12, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    iget-object v4, v0, La/b/b/a/k$f;->b:Landroid/graphics/Path;

    move/from16 v16, v5

    .end local v5    # "scaleX":F
    .local v16, "scaleX":F
    const/4 v5, 0x0

    invoke-virtual {v12, v4, v5}, Landroid/graphics/PathMeasure;->setPath(Landroid/graphics/Path;Z)V

    .line 1293
    iget-object v4, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    invoke-virtual {v4}, Landroid/graphics/PathMeasure;->getLength()F

    move-result v4

    .line 1294
    .local v4, "len":F
    mul-float v15, v15, v4

    .line 1295
    mul-float v1, v1, v4

    .line 1296
    invoke-virtual {v13}, Landroid/graphics/Path;->reset()V

    .line 1297
    cmpl-float v5, v15, v1

    if-lez v5, :cond_5

    .line 1298
    iget-object v5, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    const/4 v12, 0x1

    invoke-virtual {v5, v15, v4, v13, v12}, Landroid/graphics/PathMeasure;->getSegment(FFLandroid/graphics/Path;Z)Z

    .line 1299
    iget-object v5, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    move/from16 v17, v4

    const/4 v4, 0x0

    .end local v4    # "len":F
    .local v17, "len":F
    invoke-virtual {v5, v4, v1, v13, v12}, Landroid/graphics/PathMeasure;->getSegment(FFLandroid/graphics/Path;Z)Z

    goto :goto_1

    .line 1301
    .end local v17    # "len":F
    .restart local v4    # "len":F
    :cond_5
    move/from16 v17, v4

    const/4 v4, 0x0

    const/4 v12, 0x1

    .end local v4    # "len":F
    .restart local v17    # "len":F
    iget-object v5, v0, La/b/b/a/k$f;->g:Landroid/graphics/PathMeasure;

    invoke-virtual {v5, v15, v1, v13, v12}, Landroid/graphics/PathMeasure;->getSegment(FFLandroid/graphics/Path;Z)Z

    .line 1303
    :goto_1
    invoke-virtual {v13, v4, v4}, Landroid/graphics/Path;->rLineTo(FF)V

    .line 1305
    .end local v1    # "end":F
    .end local v15    # "start":F
    .end local v17    # "len":F
    :goto_2
    iget-object v1, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    iget-object v4, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v1, v13, v4}, Landroid/graphics/Path;->addPath(Landroid/graphics/Path;Landroid/graphics/Matrix;)V

    .line 1307
    iget-object v1, v14, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    invoke-virtual {v1}, La/b/c/a/a/b;->e()Z

    move-result v1

    const/high16 v4, 0x437f0000    # 255.0f

    if-eqz v1, :cond_9

    .line 1308
    iget-object v1, v14, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    .line 1309
    .local v1, "fill":La/b/c/a/a/b;
    iget-object v5, v0, La/b/b/a/k$f;->f:Landroid/graphics/Paint;

    if-nez v5, :cond_6

    .line 1310
    new-instance v5, Landroid/graphics/Paint;

    const/4 v12, 0x1

    invoke-direct {v5, v12}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v5, v0, La/b/b/a/k$f;->f:Landroid/graphics/Paint;

    .line 1311
    iget-object v5, v0, La/b/b/a/k$f;->f:Landroid/graphics/Paint;

    sget-object v12, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 1314
    :cond_6
    iget-object v5, v0, La/b/b/a/k$f;->f:Landroid/graphics/Paint;

    .line 1315
    .local v5, "fillPaint":Landroid/graphics/Paint;
    invoke-virtual {v1}, La/b/c/a/a/b;->c()Z

    move-result v12

    if-eqz v12, :cond_7

    .line 1316
    invoke-virtual {v1}, La/b/c/a/a/b;->b()Landroid/graphics/Shader;

    move-result-object v12

    .line 1317
    .local v12, "shader":Landroid/graphics/Shader;
    iget-object v15, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v12, v15}, Landroid/graphics/Shader;->setLocalMatrix(Landroid/graphics/Matrix;)V

    .line 1318
    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 1319
    iget v15, v14, La/b/b/a/k$b;->j:F

    mul-float v15, v15, v4

    invoke-static {v15}, Ljava/lang/Math;->round(F)I

    move-result v15

    invoke-virtual {v5, v15}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 1320
    .end local v12    # "shader":Landroid/graphics/Shader;
    goto :goto_3

    .line 1321
    :cond_7
    invoke-virtual {v1}, La/b/c/a/a/b;->a()I

    move-result v12

    iget v15, v14, La/b/b/a/k$b;->j:F

    invoke-static {v12, v15}, La/b/b/a/k;->a(IF)I

    move-result v12

    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setColor(I)V

    .line 1323
    :goto_3
    invoke-virtual {v5, v3}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 1324
    iget-object v12, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    iget v15, v14, La/b/b/a/k$b;->i:I

    if-nez v15, :cond_8

    sget-object v15, Landroid/graphics/Path$FillType;->WINDING:Landroid/graphics/Path$FillType;

    goto :goto_4

    :cond_8
    sget-object v15, Landroid/graphics/Path$FillType;->EVEN_ODD:Landroid/graphics/Path$FillType;

    :goto_4
    invoke-virtual {v12, v15}, Landroid/graphics/Path;->setFillType(Landroid/graphics/Path$FillType;)V

    .line 1326
    iget-object v12, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    invoke-virtual {v2, v12, v5}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 1329
    .end local v1    # "fill":La/b/c/a/a/b;
    .end local v5    # "fillPaint":Landroid/graphics/Paint;
    :cond_9
    iget-object v1, v14, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    invoke-virtual {v1}, La/b/c/a/a/b;->e()Z

    move-result v1

    if-eqz v1, :cond_e

    .line 1330
    iget-object v1, v14, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    .line 1331
    .local v1, "strokeColor":La/b/c/a/a/b;
    iget-object v5, v0, La/b/b/a/k$f;->e:Landroid/graphics/Paint;

    if-nez v5, :cond_a

    .line 1332
    new-instance v5, Landroid/graphics/Paint;

    const/4 v12, 0x1

    invoke-direct {v5, v12}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v5, v0, La/b/b/a/k$f;->e:Landroid/graphics/Paint;

    .line 1333
    iget-object v5, v0, La/b/b/a/k$f;->e:Landroid/graphics/Paint;

    sget-object v12, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 1336
    :cond_a
    iget-object v5, v0, La/b/b/a/k$f;->e:Landroid/graphics/Paint;

    .line 1337
    .local v5, "strokePaint":Landroid/graphics/Paint;
    iget-object v12, v14, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    if-eqz v12, :cond_b

    .line 1338
    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 1341
    :cond_b
    iget-object v12, v14, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    if-eqz v12, :cond_c

    .line 1342
    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 1345
    :cond_c
    iget v12, v14, La/b/b/a/k$b;->p:F

    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStrokeMiter(F)V

    .line 1346
    invoke-virtual {v1}, La/b/c/a/a/b;->c()Z

    move-result v12

    if-eqz v12, :cond_d

    .line 1347
    invoke-virtual {v1}, La/b/c/a/a/b;->b()Landroid/graphics/Shader;

    move-result-object v12

    .line 1348
    .restart local v12    # "shader":Landroid/graphics/Shader;
    iget-object v15, v0, La/b/b/a/k$f;->d:Landroid/graphics/Matrix;

    invoke-virtual {v12, v15}, Landroid/graphics/Shader;->setLocalMatrix(Landroid/graphics/Matrix;)V

    .line 1349
    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 1350
    iget v15, v14, La/b/b/a/k$b;->h:F

    mul-float v15, v15, v4

    invoke-static {v15}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v5, v4}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 1351
    .end local v12    # "shader":Landroid/graphics/Shader;
    goto :goto_5

    .line 1352
    :cond_d
    invoke-virtual {v1}, La/b/c/a/a/b;->a()I

    move-result v4

    iget v12, v14, La/b/b/a/k$b;->h:F

    invoke-static {v4, v12}, La/b/b/a/k;->a(IF)I

    move-result v4

    invoke-virtual {v5, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 1355
    :goto_5
    invoke-virtual {v5, v3}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 1356
    mul-float v4, v8, v11

    .line 1357
    .local v4, "finalStrokeScale":F
    iget v12, v14, La/b/b/a/k$b;->f:F

    mul-float v12, v12, v4

    invoke-virtual {v5, v12}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 1358
    iget-object v12, v0, La/b/b/a/k$f;->c:Landroid/graphics/Path;

    invoke-virtual {v2, v12, v5}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 1361
    .end local v1    # "strokeColor":La/b/c/a/a/b;
    .end local v4    # "finalStrokeScale":F
    .end local v5    # "strokePaint":Landroid/graphics/Paint;
    .end local v14    # "fullPath":La/b/b/a/k$b;
    :cond_e
    :goto_6
    return-void
.end method

.method private a(La/b/b/a/k$c;Landroid/graphics/Matrix;Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V
    .locals 18
    .param p1, "currentGroup"    # La/b/b/a/k$c;
    .param p2, "currentMatrix"    # Landroid/graphics/Matrix;
    .param p3, "canvas"    # Landroid/graphics/Canvas;
    .param p4, "w"    # I
    .param p5, "h"    # I
    .param p6, "filter"    # Landroid/graphics/ColorFilter;

    .line 1230
    move-object/from16 v7, p1

    iget-object v0, v7, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    move-object/from16 v8, p2

    invoke-virtual {v0, v8}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 1232
    iget-object v0, v7, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    iget-object v1, v7, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->preConcat(Landroid/graphics/Matrix;)Z

    .line 1235
    invoke-virtual/range {p3 .. p3}, Landroid/graphics/Canvas;->save()I

    .line 1238
    const/4 v0, 0x0

    move v9, v0

    .local v9, "i":I
    :goto_0
    iget-object v0, v7, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v9, v0, :cond_2

    .line 1239
    iget-object v0, v7, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v10, v0

    check-cast v10, La/b/b/a/k$d;

    .line 1240
    .local v10, "child":La/b/b/a/k$d;
    instance-of v0, v10, La/b/b/a/k$c;

    if-eqz v0, :cond_0

    .line 1241
    move-object v0, v10

    check-cast v0, La/b/b/a/k$c;

    .line 1242
    .local v0, "childGroup":La/b/b/a/k$c;
    iget-object v13, v7, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    move-object/from16 v11, p0

    move-object v12, v0

    move-object/from16 v14, p3

    move/from16 v15, p4

    move/from16 v16, p5

    move-object/from16 v17, p6

    invoke-direct/range {v11 .. v17}, La/b/b/a/k$f;->a(La/b/b/a/k$c;Landroid/graphics/Matrix;Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V

    .end local v0    # "childGroup":La/b/b/a/k$c;
    goto :goto_1

    .line 1244
    :cond_0
    instance-of v0, v10, La/b/b/a/k$e;

    if-eqz v0, :cond_1

    .line 1245
    move-object v11, v10

    check-cast v11, La/b/b/a/k$e;

    .line 1246
    .local v11, "childPath":La/b/b/a/k$e;
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object v2, v11

    move-object/from16 v3, p3

    move/from16 v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    invoke-direct/range {v0 .. v6}, La/b/b/a/k$f;->a(La/b/b/a/k$c;La/b/b/a/k$e;Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V

    goto :goto_2

    .line 1244
    .end local v11    # "childPath":La/b/b/a/k$e;
    :cond_1
    :goto_1
    nop

    .line 1238
    .end local v10    # "child":La/b/b/a/k$d;
    :goto_2
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 1250
    .end local v9    # "i":I
    :cond_2
    invoke-virtual/range {p3 .. p3}, Landroid/graphics/Canvas;->restore()V

    .line 1251
    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "w"    # I
    .param p3, "h"    # I
    .param p4, "filter"    # Landroid/graphics/ColorFilter;

    .line 1255
    iget-object v1, p0, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    sget-object v2, La/b/b/a/k$f;->a:Landroid/graphics/Matrix;

    move-object v0, p0

    move-object v3, p1

    move v4, p2

    move v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, La/b/b/a/k$f;->a(La/b/b/a/k$c;Landroid/graphics/Matrix;Landroid/graphics/Canvas;IILandroid/graphics/ColorFilter;)V

    .line 1256
    return-void
.end method

.method public a()Z
    .locals 1

    .line 1397
    iget-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 1398
    iget-object v0, p0, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    invoke-virtual {v0}, La/b/b/a/k$c;->a()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    .line 1400
    :cond_0
    iget-object v0, p0, La/b/b/a/k$f;->p:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public a([I)Z
    .locals 1
    .param p1, "stateSet"    # [I

    .line 1404
    iget-object v0, p0, La/b/b/a/k$f;->i:La/b/b/a/k$c;

    invoke-virtual {v0, p1}, La/b/b/a/k$c;->a([I)Z

    move-result v0

    return v0
.end method

.method public getAlpha()F
    .locals 2

    .line 1204
    invoke-virtual {p0}, La/b/b/a/k$f;->getRootAlpha()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x437f0000    # 255.0f

    div-float/2addr v0, v1

    return v0
.end method

.method public getRootAlpha()I
    .locals 1

    .line 1193
    iget v0, p0, La/b/b/a/k$f;->n:I

    return v0
.end method

.method public setAlpha(F)V
    .locals 1
    .param p1, "alpha"    # F

    .line 1199
    const/high16 v0, 0x437f0000    # 255.0f

    mul-float v0, v0, p1

    float-to-int v0, v0

    invoke-virtual {p0, v0}, La/b/b/a/k$f;->setRootAlpha(I)V

    .line 1200
    return-void
.end method

.method public setRootAlpha(I)V
    .locals 0
    .param p1, "alpha"    # I

    .line 1189
    iput p1, p0, La/b/b/a/k$f;->n:I

    .line 1190
    return-void
.end method
