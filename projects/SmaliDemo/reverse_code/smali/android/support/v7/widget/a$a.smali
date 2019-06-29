.class public Landroid/support/v7/widget/a$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/g/B;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "a"
.end annotation


# instance fields
.field private a:Z

.field b:I

.field final synthetic c:Landroid/support/v7/widget/a;


# direct methods
.method protected constructor <init>(Landroid/support/v7/widget/a;)V
    .locals 1
    .param p1, "this$0"    # Landroid/support/v7/widget/a;

    .line 273
    iput-object p1, p0, Landroid/support/v7/widget/a$a;->c:Landroid/support/v7/widget/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 274
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/a$a;->a:Z

    return-void
.end method


# virtual methods
.method public a(La/b/c/g/A;I)Landroid/support/v7/widget/a$a;
    .locals 1
    .param p1, "animation"    # La/b/c/g/A;
    .param p2, "visibility"    # I

    .line 279
    iget-object v0, p0, Landroid/support/v7/widget/a$a;->c:Landroid/support/v7/widget/a;

    iput-object p1, v0, Landroid/support/v7/widget/a;->f:La/b/c/g/A;

    .line 280
    iput p2, p0, Landroid/support/v7/widget/a$a;->b:I

    .line 281
    return-object p0
.end method

.method public a(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 300
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/a$a;->a:Z

    .line 301
    return-void
.end method

.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 292
    iget-boolean v0, p0, Landroid/support/v7/widget/a$a;->a:Z

    if-eqz v0, :cond_0

    return-void

    .line 294
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/a$a;->c:Landroid/support/v7/widget/a;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/a;->f:La/b/c/g/A;

    .line 295
    iget v1, p0, Landroid/support/v7/widget/a$a;->b:I

    invoke-static {v0, v1}, Landroid/support/v7/widget/a;->b(Landroid/support/v7/widget/a;I)V

    .line 296
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 286
    iget-object v0, p0, Landroid/support/v7/widget/a$a;->c:Landroid/support/v7/widget/a;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/support/v7/widget/a;->a(Landroid/support/v7/widget/a;I)V

    .line 287
    iput-boolean v1, p0, Landroid/support/v7/widget/a$a;->a:Z

    .line 288
    return-void
.end method
