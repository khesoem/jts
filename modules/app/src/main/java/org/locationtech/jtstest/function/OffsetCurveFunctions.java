/*
 * Copyright (c) 2016 Vivid Solutions.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v20.html
 * and the Eclipse Distribution License is available at
 *
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.locationtech.jtstest.function;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.util.GeometryCombiner;
import org.locationtech.jts.operation.buffer.OffsetCurve;

public class OffsetCurveFunctions {

  public static Geometry offsetCurve(Geometry geom, double distance)
  {
    return OffsetCurve.getCurve(geom, distance);
  }

  public static Geometry offsetCurveBoth(Geometry geom, double distance)
  {
    Geometry curve1 = OffsetCurve.getCurve(geom, distance);
    Geometry curve2 = OffsetCurve.getCurve(geom, -distance);
    return GeometryCombiner.combine(curve1, curve2);
  }

  public static Geometry rawCurve(Geometry geom, double distance)
  {
    Coordinate[] pts = OffsetCurve.rawOffset((LineString) geom, distance);
    Geometry curve = geom.getFactory().createLineString(pts);
    return curve;
  }

}
