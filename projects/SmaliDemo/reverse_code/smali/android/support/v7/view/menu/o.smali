.class Landroid/support/v7/view/menu/o;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/g/e$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/view/menu/p;->a(La/b/c/g/e;)La/b/c/c/a/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/p;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/p;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/p;

    .line 800
    iput-object p1, p0, Landroid/support/v7/view/menu/o;->a:Landroid/support/v7/view/menu/p;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionProviderVisibilityChanged(Z)V
    .locals 2
    .param p1, "isVisible"    # Z

    .line 803
    iget-object v0, p0, Landroid/support/v7/view/menu/o;->a:Landroid/support/v7/view/menu/p;

    iget-object v1, v0, Landroid/support/v7/view/menu/p;->n:Landroid/support/v7/view/menu/l;

    invoke-virtual {v1, v0}, Landroid/support/v7/view/menu/l;->d(Landroid/support/v7/view/menu/p;)V

    .line 804
    return-void
.end method
