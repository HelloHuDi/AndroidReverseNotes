.class La/b/d/d/h;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/d/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private a:Z

.field private b:I

.field final synthetic c:La/b/d/d/i;


# direct methods
.method constructor <init>(La/b/d/d/i;)V
    .locals 1
    .param p1, "this$0"    # La/b/d/d/i;

    .line 121
    iput-object p1, p0, La/b/d/d/h;->c:La/b/d/d/i;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    .line 122
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/d/h;->a:Z

    .line 123
    iput v0, p0, La/b/d/d/h;->b:I

    return-void
.end method


# virtual methods
.method a()V
    .locals 1

    .line 137
    const/4 v0, 0x0

    iput v0, p0, La/b/d/d/h;->b:I

    .line 138
    iput-boolean v0, p0, La/b/d/d/h;->a:Z

    .line 139
    iget-object v0, p0, La/b/d/d/h;->c:La/b/d/d/i;

    invoke-virtual {v0}, La/b/d/d/i;->b()V

    .line 140
    return-void
.end method

.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 144
    iget v0, p0, La/b/d/d/h;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, La/b/d/d/h;->b:I

    iget-object v1, p0, La/b/d/d/h;->c:La/b/d/d/i;

    iget-object v1, v1, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 145
    iget-object v0, p0, La/b/d/d/h;->c:La/b/d/d/i;

    iget-object v0, v0, La/b/d/d/i;->d:La/b/c/g/B;

    if-eqz v0, :cond_0

    .line 146
    const/4 v1, 0x0

    invoke-interface {v0, v1}, La/b/c/g/B;->b(Landroid/view/View;)V

    .line 148
    :cond_0
    invoke-virtual {p0}, La/b/d/d/h;->a()V

    .line 150
    :cond_1
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 127
    iget-boolean v0, p0, La/b/d/d/h;->a:Z

    if-eqz v0, :cond_0

    .line 128
    return-void

    .line 130
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/d/h;->a:Z

    .line 131
    iget-object v0, p0, La/b/d/d/h;->c:La/b/d/d/i;

    iget-object v0, v0, La/b/d/d/i;->d:La/b/c/g/B;

    if-eqz v0, :cond_1

    .line 132
    const/4 v1, 0x0

    invoke-interface {v0, v1}, La/b/c/g/B;->c(Landroid/view/View;)V

    .line 134
    :cond_1
    return-void
.end method
