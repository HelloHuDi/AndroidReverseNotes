.class Landroid/support/v7/widget/G;
.super La/b/c/a/a/h$a;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/H;->a(Landroid/content/Context;Landroid/support/v7/widget/ta;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/ref/WeakReference;

.field final synthetic b:Landroid/support/v7/widget/H;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/H;Ljava/lang/ref/WeakReference;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/H;

    .line 252
    iput-object p1, p0, Landroid/support/v7/widget/G;->b:Landroid/support/v7/widget/H;

    iput-object p2, p0, Landroid/support/v7/widget/G;->a:Ljava/lang/ref/WeakReference;

    invoke-direct {p0}, La/b/c/a/a/h$a;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 0
    .param p1, "reason"    # I

    .line 261
    return-void
.end method

.method public a(Landroid/graphics/Typeface;)V
    .locals 2
    .param p1, "typeface"    # Landroid/graphics/Typeface;

    .line 255
    iget-object v0, p0, Landroid/support/v7/widget/G;->b:Landroid/support/v7/widget/H;

    iget-object v1, p0, Landroid/support/v7/widget/G;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0, v1, p1}, Landroid/support/v7/widget/H;->a(Ljava/lang/ref/WeakReference;Landroid/graphics/Typeface;)V

    .line 256
    return-void
.end method
