import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("dl")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1485716275
   )
   @Export("ItemDefinition_fileCount")
   public static int ItemDefinition_fileCount;
   @ObfuscatedName("af")
   @Export("isRunning")
   boolean isRunning = true;
   @ObfuscatedName("an")
   @Export("lock")
   Object lock = new Object();
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 535437747
   )
   @Export("index")
   int index = 0;
   @ObfuscatedName("ac")
   @Export("xs")
   int[] xs = new int[500];
   @ObfuscatedName("au")
   @Export("ys")
   int[] ys = new int[500];
   @ObfuscatedName("ab")
   @Export("millis")
   long[] millis = new long[500];

   MouseRecorder() {
   }

   public void run() {
      for(; this.isRunning; PlayerComposition.method6084(50L)) {
         synchronized(this.lock) {
            if (this.index < 500) {
               this.xs[this.index] = MouseHandler.MouseHandler_x;
               this.ys[this.index] = MouseHandler.MouseHandler_y;
               this.millis[this.index] = MouseHandler.MouseHandler_millis;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1929251930"
   )
   static final boolean method2266(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(IB)Lcq;",
      garbageValue = "32"
   )
   @Export("Messages_getMessage")
   static Message Messages_getMessage(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "-471758785"
   )
   static int method2268(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 6600) {
         var3 = GameEngine.Client_plane;
         int var15 = WorldMapData_0.baseX * 64 + (MusicPatchNode.localPlayer.x >> 7);
         int var8 = GameObject.baseY * 64 + (MusicPatchNode.localPlayer.y >> 7);
         class88.getWorldMap().method8628(var3, var15, var8, true);
         return 1;
      } else {
         WorldMapArea var9;
         if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            String var16 = "";
            var9 = class88.getWorldMap().getMapArea(var3);
            if (var9 != null) {
               var16 = var9.getExternalName();
            }

            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var16;
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class88.getWorldMap().setCurrentMapAreaId(var3);
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getZoomLevel();
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class88.getWorldMap().setZoomPercentage(var3);
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isCacheLoaded() ? 1 : 0;
            return 1;
         } else {
            Coord var14;
            if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
               var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().setWorldMapPositionTarget(var14.x, var14.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
               var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().setWorldMapPositionTargetInstant(var14.x, var14.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
               var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().jumpToSourceCoord(var14.plane, var14.x, var14.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
               var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().jumpToSourceCoordInstant(var14.plane, var14.x, var14.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayX();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayY();
               return 1;
            } else {
               WorldMapArea var11;
               if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = class88.getWorldMap().getMapArea(var3);
                  if (var11 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getOrigin().packed();
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = class88.getWorldMap().getMapArea(var3);
                  if (var11 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var11.getRegionHighX() - var11.getRegionLowX() + 1) * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var11.getRegionHighY() - var11.getRegionLowY() + 1) * 64;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = class88.getWorldMap().getMapArea(var3);
                  if (var11 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getRegionLowX() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getRegionLowY() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getRegionHighX() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getRegionHighY() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = class88.getWorldMap().getMapArea(var3);
                  if (var11 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getZoom();
                  }

                  return 1;
               } else if (var0 == 6615) {
                  var14 = class88.getWorldMap().getDisplayCoord();
                  if (var14 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.x;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.y;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().currentMapAreaId();
                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
                  var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                  var11 = class88.getWorldMap().getCurrentMapArea();
                  if (var11 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var12 = var11.position(var14.plane, var14.x, var14.y);
                     if (var12 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12[0];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12[1];
                     }

                     return 1;
                  }
               } else {
                  Coord var5;
                  if (var0 == 6618) {
                     var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                     var11 = class88.getWorldMap().getCurrentMapArea();
                     if (var11 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var5 = var11.coord(var14.x, var14.y);
                        if (var5 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.packed();
                        }

                        return 1;
                     }
                  } else {
                     Coord var10;
                     if (var0 == 6619) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var10 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class220.method4493(var3, var10, false);
                        return 1;
                     } else if (var0 == 6620) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var10 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class220.method4493(var3, var10, true);
                        return 1;
                     } else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var10 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        var9 = class88.getWorldMap().getMapArea(var3);
                        if (var9 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.containsCoord(var10.plane, var10.x, var10.y) ? 1 : 0;
                           return 1;
                        }
                     } else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayWith();
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayHeight();
                        return 1;
                     } else if (var0 == 6623) {
                        var14 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        var11 = class88.getWorldMap().mapAreaAtCoord(var14.plane, var14.x, var14.y);
                        if (var11 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.getId();
                        }

                        return 1;
                     } else if (var0 == 6624) {
                        class88.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6625) {
                        class88.getWorldMap().resetMaxFlashCount();
                        return 1;
                     } else if (var0 == 6626) {
                        class88.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6627) {
                        class88.getWorldMap().resetCyclesPerFlash();
                        return 1;
                     } else {
                        boolean var13;
                        if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
                           var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class88.getWorldMap().setPerpetualFlash(var13);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class88.getWorldMap().flashElement(var3);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class88.getWorldMap().flashCategory(var3);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
                           class88.getWorldMap().stopCurrentFlashes();
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
                           var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class88.getWorldMap().setElementsDisabled(var13);
                           return 1;
                        } else {
                           boolean var7;
                           if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class88.getWorldMap().disableElement(var3, var7);
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class88.getWorldMap().setCategoryDisabled(var3, var7);
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getElementsDisabled() ? 1 : 0;
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isElementDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6638) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var10 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                              var5 = class88.getWorldMap().method8660(var3, var10);
                              if (var5 == null) {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.packed();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var6;
                              if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
                                 var6 = class88.getWorldMap().iconStart();
                                 if (var6 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.getElement();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.coord2.packed();
                                 }

                                 return 1;
                              } else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
                                 var6 = class88.getWorldMap().iconNext();
                                 if (var6 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.getElement();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.coord2.packed();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var4;
                                 if (var0 == ScriptOpcodes.MEC_TEXT) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var4 = class354.WorldMapElement_get(var3);
                                    if (var4.name == null) {
                                       Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.name;
                                    }

                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var4 = class354.WorldMapElement_get(var3);
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.textSize;
                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var4 = class354.WorldMapElement_get(var3);
                                    if (var4 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.category;
                                    }

                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_SPRITE) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var4 = class354.WorldMapElement_get(var3);
                                    if (var4 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.sprite1;
                                    }

                                    return 1;
                                 } else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.mapElement;
                                    return 1;
                                 } else if (var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.coord1.packed();
                                    return 1;
                                 } else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.coord2.packed();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
