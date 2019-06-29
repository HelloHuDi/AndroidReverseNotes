.class public La/b/c/g/m;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private a:Landroid/view/ViewParent;

.field private b:Landroid/view/ViewParent;

.field private final c:Landroid/view/View;

.field private d:Z

.field private e:[I


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object p1, p0, La/b/c/g/m;->c:Landroid/view/View;

    .line 58
    return-void
.end method

.method private a(ILandroid/view/ViewParent;)V
    .locals 1
    .param p1, "type"    # I
    .param p2, "p"    # Landroid/view/ViewParent;

    .line 393
    if-eqz p1, :cond_1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    goto :goto_0

    .line 398
    :cond_0
    iput-object p2, p0, La/b/c/g/m;->b:Landroid/view/ViewParent;

    goto :goto_0

    .line 395
    :cond_1
    iput-object p2, p0, La/b/c/g/m;->a:Landroid/view/ViewParent;

    .line 396
    nop

    .line 401
    :goto_0
    return-void
.end method

.method private c(I)Landroid/view/ViewParent;
    .locals 1
    .param p1, "type"    # I

    .line 383
    if-eqz p1, :cond_1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    .line 389
    const/4 v0, 0x0

    return-object v0

    .line 387
    :cond_0
    iget-object v0, p0, La/b/c/g/m;->b:Landroid/view/ViewParent;

    return-object v0

    .line 385
    :cond_1
    iget-object v0, p0, La/b/c/g/m;->a:Landroid/view/ViewParent;

    return-object v0
.end method


# virtual methods
.method public a(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .line 70
    iget-boolean v0, p0, La/b/c/g/m;->d:Z

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0}, La/b/c/g/u;->n(Landroid/view/View;)V

    .line 73
    :cond_0
    iput-boolean p1, p0, La/b/c/g/m;->d:Z

    .line 74
    return-void
.end method

.method public a()Z
    .locals 1

    .line 86
    iget-boolean v0, p0, La/b/c/g/m;->d:Z

    return v0
.end method

.method public a(FF)Z
    .locals 2
    .param p1, "velocityX"    # F
    .param p2, "velocityY"    # F

    .line 347
    invoke-virtual {p0}, La/b/c/g/m;->a()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 348
    invoke-direct {p0, v1}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v0

    .line 349
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 350
    iget-object v1, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0, v1, p1, p2}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;FF)Z

    move-result v1

    return v1

    .line 354
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_0
    return v1
.end method

.method public a(FFZ)Z
    .locals 2
    .param p1, "velocityX"    # F
    .param p2, "velocityY"    # F
    .param p3, "consumed"    # Z

    .line 327
    invoke-virtual {p0}, La/b/c/g/m;->a()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 328
    invoke-direct {p0, v1}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v0

    .line 329
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 330
    iget-object v1, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0, v1, p1, p2, p3}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;FFZ)Z

    move-result v1

    return v1

    .line 334
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_0
    return v1
.end method

.method public a(I)Z
    .locals 1
    .param p1, "type"    # I

    .line 114
    invoke-direct {p0, p1}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public a(II)Z
    .locals 4
    .param p1, "axes"    # I
    .param p2, "type"    # I

    .line 145
    invoke-virtual {p0, p2}, La/b/c/g/m;->a(I)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 147
    return v1

    .line 149
    :cond_0
    invoke-virtual {p0}, La/b/c/g/m;->a()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 150
    iget-object v0, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 151
    .local v0, "p":Landroid/view/ViewParent;
    iget-object v2, p0, La/b/c/g/m;->c:Landroid/view/View;

    .line 152
    .local v2, "child":Landroid/view/View;
    :goto_0
    if-eqz v0, :cond_3

    .line 153
    iget-object v3, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0, v2, v3, p1, p2}, La/b/c/g/x;->b(Landroid/view/ViewParent;Landroid/view/View;Landroid/view/View;II)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 154
    invoke-direct {p0, p2, v0}, La/b/c/g/m;->a(ILandroid/view/ViewParent;)V

    .line 155
    iget-object v3, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0, v2, v3, p1, p2}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;Landroid/view/View;II)V

    .line 156
    return v1

    .line 158
    :cond_1
    instance-of v3, v0, Landroid/view/View;

    if-eqz v3, :cond_2

    .line 159
    move-object v2, v0

    check-cast v2, Landroid/view/View;

    .line 161
    :cond_2
    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    goto :goto_0

    .line 164
    .end local v0    # "p":Landroid/view/ViewParent;
    .end local v2    # "child":Landroid/view/View;
    :cond_3
    const/4 v0, 0x0

    return v0
.end method

.method public a(IIII[II)Z
    .locals 15
    .param p1, "dxConsumed"    # I
    .param p2, "dyConsumed"    # I
    .param p3, "dxUnconsumed"    # I
    .param p4, "dyUnconsumed"    # I
    .param p5, "offsetInWindow"    # [I
    .param p6, "type"    # I

    .line 220
    move-object v0, p0

    move-object/from16 v1, p5

    invoke-virtual {p0}, La/b/c/g/m;->a()Z

    move-result v2

    const/4 v3, 0x0

    if-eqz v2, :cond_5

    .line 221
    move/from16 v2, p6

    invoke-direct {p0, v2}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v11

    .line 222
    .local v11, "parent":Landroid/view/ViewParent;
    if-nez v11, :cond_0

    .line 223
    return v3

    .line 226
    :cond_0
    const/4 v12, 0x1

    if-nez p1, :cond_2

    if-nez p2, :cond_2

    if-nez p3, :cond_2

    if-eqz p4, :cond_1

    goto :goto_0

    .line 244
    :cond_1
    if-eqz v1, :cond_6

    .line 246
    aput v3, v1, v3

    .line 247
    aput v3, v1, v12

    goto :goto_2

    .line 227
    :cond_2
    :goto_0
    const/4 v4, 0x0

    .line 228
    .local v4, "startX":I
    const/4 v5, 0x0

    .line 229
    .local v5, "startY":I
    if-eqz v1, :cond_3

    .line 230
    iget-object v6, v0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-virtual {v6, v1}, Landroid/view/View;->getLocationInWindow([I)V

    .line 231
    aget v4, v1, v3

    .line 232
    aget v5, v1, v12

    move v13, v4

    move v14, v5

    goto :goto_1

    .line 229
    :cond_3
    move v13, v4

    move v14, v5

    .line 235
    .end local v4    # "startX":I
    .end local v5    # "startY":I
    .local v13, "startX":I
    .local v14, "startY":I
    :goto_1
    iget-object v5, v0, La/b/c/g/m;->c:Landroid/view/View;

    move-object v4, v11

    move/from16 v6, p1

    move/from16 v7, p2

    move/from16 v8, p3

    move/from16 v9, p4

    move/from16 v10, p6

    invoke-static/range {v4 .. v10}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;IIIII)V

    .line 238
    if-eqz v1, :cond_4

    .line 239
    iget-object v4, v0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-virtual {v4, v1}, Landroid/view/View;->getLocationInWindow([I)V

    .line 240
    aget v4, v1, v3

    sub-int/2addr v4, v13

    aput v4, v1, v3

    .line 241
    aget v3, v1, v12

    sub-int/2addr v3, v14

    aput v3, v1, v12

    .line 243
    :cond_4
    return v12

    .line 220
    .end local v11    # "parent":Landroid/view/ViewParent;
    .end local v13    # "startX":I
    .end local v14    # "startY":I
    :cond_5
    move/from16 v2, p6

    .line 250
    :cond_6
    :goto_2
    return v3
.end method

.method public a(II[I[II)Z
    .locals 15
    .param p1, "dx"    # I
    .param p2, "dy"    # I
    .param p3, "consumed"    # [I
    .param p4, "offsetInWindow"    # [I
    .param p5, "type"    # I

    .line 278
    move-object v0, p0

    move-object/from16 v1, p4

    invoke-virtual {p0}, La/b/c/g/m;->a()Z

    move-result v2

    const/4 v3, 0x0

    if-eqz v2, :cond_9

    .line 279
    move/from16 v2, p5

    invoke-direct {p0, v2}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v10

    .line 280
    .local v10, "parent":Landroid/view/ViewParent;
    if-nez v10, :cond_0

    .line 281
    return v3

    .line 284
    :cond_0
    const/4 v11, 0x1

    if-nez p1, :cond_2

    if-eqz p2, :cond_1

    goto :goto_0

    .line 309
    :cond_1
    if-eqz v1, :cond_a

    .line 310
    aput v3, v1, v3

    .line 311
    aput v3, v1, v11

    goto :goto_4

    .line 285
    :cond_2
    :goto_0
    const/4 v4, 0x0

    .line 286
    .local v4, "startX":I
    const/4 v5, 0x0

    .line 287
    .local v5, "startY":I
    if-eqz v1, :cond_3

    .line 288
    iget-object v6, v0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-virtual {v6, v1}, Landroid/view/View;->getLocationInWindow([I)V

    .line 289
    aget v4, v1, v3

    .line 290
    aget v5, v1, v11

    move v12, v4

    move v13, v5

    goto :goto_1

    .line 287
    :cond_3
    move v12, v4

    move v13, v5

    .line 293
    .end local v4    # "startX":I
    .end local v5    # "startY":I
    .local v12, "startX":I
    .local v13, "startY":I
    :goto_1
    if-nez p3, :cond_5

    .line 294
    iget-object v4, v0, La/b/c/g/m;->e:[I

    if-nez v4, :cond_4

    .line 295
    const/4 v4, 0x2

    new-array v4, v4, [I

    iput-object v4, v0, La/b/c/g/m;->e:[I

    .line 297
    :cond_4
    iget-object v4, v0, La/b/c/g/m;->e:[I

    move-object v14, v4

    .end local p3    # "consumed":[I
    .local v4, "consumed":[I
    goto :goto_2

    .line 293
    .end local v4    # "consumed":[I
    .restart local p3    # "consumed":[I
    :cond_5
    move-object/from16 v14, p3

    .line 299
    .end local p3    # "consumed":[I
    .local v14, "consumed":[I
    :goto_2
    aput v3, v14, v3

    .line 300
    aput v3, v14, v11

    .line 301
    iget-object v5, v0, La/b/c/g/m;->c:Landroid/view/View;

    move-object v4, v10

    move/from16 v6, p1

    move/from16 v7, p2

    move-object v8, v14

    move/from16 v9, p5

    invoke-static/range {v4 .. v9}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;II[II)V

    .line 303
    if-eqz v1, :cond_6

    .line 304
    iget-object v4, v0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-virtual {v4, v1}, Landroid/view/View;->getLocationInWindow([I)V

    .line 305
    aget v4, v1, v3

    sub-int/2addr v4, v12

    aput v4, v1, v3

    .line 306
    aget v4, v1, v11

    sub-int/2addr v4, v13

    aput v4, v1, v11

    .line 308
    :cond_6
    aget v4, v14, v3

    if-nez v4, :cond_8

    aget v4, v14, v11

    if-eqz v4, :cond_7

    goto :goto_3

    :cond_7
    const/4 v11, 0x0

    :cond_8
    :goto_3
    return v11

    .line 278
    .end local v10    # "parent":Landroid/view/ViewParent;
    .end local v12    # "startX":I
    .end local v13    # "startY":I
    .end local v14    # "consumed":[I
    .restart local p3    # "consumed":[I
    :cond_9
    move/from16 v2, p5

    .line 314
    :cond_a
    :goto_4
    return v3
.end method

.method public b(I)V
    .locals 2
    .param p1, "type"    # I

    .line 186
    invoke-direct {p0, p1}, La/b/c/g/m;->c(I)Landroid/view/ViewParent;

    move-result-object v0

    .line 187
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 188
    iget-object v1, p0, La/b/c/g/m;->c:Landroid/view/View;

    invoke-static {v0, v1, p1}, La/b/c/g/x;->a(Landroid/view/ViewParent;Landroid/view/View;I)V

    .line 189
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, La/b/c/g/m;->a(ILandroid/view/ViewParent;)V

    .line 191
    :cond_0
    return-void
.end method
