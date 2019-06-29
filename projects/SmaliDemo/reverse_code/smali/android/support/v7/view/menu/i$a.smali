.class Landroid/support/v7/view/menu/i$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field public final a:Landroid/support/v7/widget/W;

.field public final b:Landroid/support/v7/view/menu/l;

.field public final c:I


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/W;Landroid/support/v7/view/menu/l;I)V
    .locals 0
    .param p1, "window"    # Landroid/support/v7/widget/W;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;
    .param p3, "position"    # I

    .line 800
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 801
    iput-object p1, p0, Landroid/support/v7/view/menu/i$a;->a:Landroid/support/v7/widget/W;

    .line 802
    iput-object p2, p0, Landroid/support/v7/view/menu/i$a;->b:Landroid/support/v7/view/menu/l;

    .line 803
    iput p3, p0, Landroid/support/v7/view/menu/i$a;->c:I

    .line 804
    return-void
.end method


# virtual methods
.method public a()Landroid/widget/ListView;
    .locals 1

    .line 807
    iget-object v0, p0, Landroid/support/v7/view/menu/i$a;->a:Landroid/support/v7/widget/W;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->d()Landroid/widget/ListView;

    move-result-object v0

    return-object v0
.end method
