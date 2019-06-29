.class abstract La/b/b/a/k$e;
.super La/b/b/a/k$d;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "e"
.end annotation


# instance fields
.field protected a:[La/b/c/b/b$b;

.field b:Ljava/lang/String;

.field c:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1675
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/b/a/k$d;-><init>(La/b/b/a/j;)V

    .line 1671
    iput-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    .line 1677
    return-void
.end method

.method public constructor <init>(La/b/b/a/k$e;)V
    .locals 1
    .param p1, "copy"    # La/b/b/a/k$e;

    .line 1701
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/b/a/k$d;-><init>(La/b/b/a/j;)V

    .line 1671
    iput-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    .line 1702
    iget-object v0, p1, La/b/b/a/k$e;->b:Ljava/lang/String;

    iput-object v0, p0, La/b/b/a/k$e;->b:Ljava/lang/String;

    .line 1703
    iget v0, p1, La/b/b/a/k$e;->c:I

    iput v0, p0, La/b/b/a/k$e;->c:I

    .line 1704
    iget-object v0, p1, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    invoke-static {v0}, La/b/c/b/b;->a([La/b/c/b/b$b;)[La/b/c/b/b$b;

    move-result-object v0

    iput-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    .line 1705
    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Path;)V
    .locals 1
    .param p1, "path"    # Landroid/graphics/Path;

    .line 1708
    invoke-virtual {p1}, Landroid/graphics/Path;->reset()V

    .line 1709
    iget-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    if-eqz v0, :cond_0

    .line 1710
    invoke-static {v0, p1}, La/b/c/b/b$b;->a([La/b/c/b/b$b;Landroid/graphics/Path;)V

    .line 1712
    :cond_0
    return-void
.end method

.method public b()Z
    .locals 1

    .line 1726
    const/4 v0, 0x0

    return v0
.end method

.method public getPathData()[La/b/c/b/b$b;
    .locals 1

    .line 1732
    iget-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    return-object v0
.end method

.method public getPathName()Ljava/lang/String;
    .locals 1

    .line 1715
    iget-object v0, p0, La/b/b/a/k$e;->b:Ljava/lang/String;

    return-object v0
.end method

.method public setPathData([La/b/c/b/b$b;)V
    .locals 1
    .param p1, "nodes"    # [La/b/c/b/b$b;

    .line 1737
    iget-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    invoke-static {v0, p1}, La/b/c/b/b;->a([La/b/c/b/b$b;[La/b/c/b/b$b;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1739
    invoke-static {p1}, La/b/c/b/b;->a([La/b/c/b/b$b;)[La/b/c/b/b$b;

    move-result-object v0

    iput-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    goto :goto_0

    .line 1741
    :cond_0
    iget-object v0, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    invoke-static {v0, p1}, La/b/c/b/b;->b([La/b/c/b/b$b;[La/b/c/b/b$b;)V

    .line 1743
    :goto_0
    return-void
.end method
