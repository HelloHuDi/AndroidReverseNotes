.class La/b/b/a/f$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/animation/TypeEvaluator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/animation/TypeEvaluator<",
        "[",
        "La/b/c/b/b$b;",
        ">;"
    }
.end annotation


# instance fields
.field private a:[La/b/c/b/b$b;


# direct methods
.method constructor <init>()V
    .locals 0

    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 167
    return-void
.end method


# virtual methods
.method public a(F[La/b/c/b/b$b;[La/b/c/b/b$b;)[La/b/c/b/b$b;
    .locals 4
    .param p1, "fraction"    # F
    .param p2, "startPathData"    # [La/b/c/b/b$b;
    .param p3, "endPathData"    # [La/b/c/b/b$b;

    .line 185
    invoke-static {p2, p3}, La/b/c/b/b;->a([La/b/c/b/b$b;[La/b/c/b/b$b;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 190
    iget-object v0, p0, La/b/b/a/f$a;->a:[La/b/c/b/b$b;

    if-eqz v0, :cond_0

    invoke-static {v0, p2}, La/b/c/b/b;->a([La/b/c/b/b$b;[La/b/c/b/b$b;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 191
    :cond_0
    invoke-static {p2}, La/b/c/b/b;->a([La/b/c/b/b$b;)[La/b/c/b/b$b;

    move-result-object v0

    iput-object v0, p0, La/b/b/a/f$a;->a:[La/b/c/b/b$b;

    .line 194
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p2

    if-ge v0, v1, :cond_2

    .line 195
    iget-object v1, p0, La/b/b/a/f$a;->a:[La/b/c/b/b$b;

    aget-object v1, v1, v0

    aget-object v2, p2, v0

    aget-object v3, p3, v0

    invoke-virtual {v1, v2, v3, p1}, La/b/c/b/b$b;->a(La/b/c/b/b$b;La/b/c/b/b$b;F)V

    .line 194
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 199
    .end local v0    # "i":I
    :cond_2
    iget-object v0, p0, La/b/b/a/f$a;->a:[La/b/c/b/b$b;

    return-object v0

    .line 186
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Can\'t interpolate between two incompatible pathData"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    goto :goto_2

    :goto_1
    throw v0

    :goto_2
    goto :goto_1
.end method

.method public bridge synthetic evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 157
    check-cast p2, [La/b/c/b/b$b;

    check-cast p3, [La/b/c/b/b$b;

    invoke-virtual {p0, p1, p2, p3}, La/b/b/a/f$a;->a(F[La/b/c/b/b$b;[La/b/c/b/b$b;)[La/b/c/b/b$b;

    move-result-object p1

    return-object p1
.end method
