/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.arthurnagy.minimalistic

import android.graphics.Color
import androidx.annotation.ColorInt
import me.arthurnagy.minimalistic.dsl.AnalogWatchFaceStyle
import me.arthurnagy.minimalistic.dsl.service.AbstractKotlinWatchFace
import me.arthurnagy.minimalistic.dsl.service.AnalogWatchFaceStyleBuilder
import me.arthurnagy.minimalistic.dsl.service.analogWatchFaceStyle

/**
 * Renders watch face via data object created by DSL.
 */
class MinimalisticAnalogWatchFace : AbstractKotlinWatchFace() {

    override fun getWatchFaceStyle(): AnalogWatchFaceStyle {

        /**
         * Initializes colors and dimensions of watch face. Review [AnalogWatchFaceStyle] for
         * detailed explanation of each field.
         */
        return analogWatchFaceStyle {
            darkTheme(getColor(R.color.orange))

            watchFaceDimensions {
                hourHandRadiusRatio = 0.7f
                minuteHandRadiusRatio = 0.8f
                secondHandRadiusRatio = 0.90f

                hourHandWidth = 8f
                minuteHandWidth = 6f
                secondHandWidth = 4f

                shadowRadius = 1f

                innerCircleRadius = 6f
                innerCircleToArmsDistance = 8f
            }
        }
    }

    private fun AnalogWatchFaceStyleBuilder.darkTheme(@ColorInt accentColor: Int = getColor(R.color.red)) =
        this.watchFaceColors {
            main = DARK_MAIN
            highlight = accentColor
            background = DARK_BACKGROUND
        }

    private fun AnalogWatchFaceStyleBuilder.lightTheme(@ColorInt accentColor: Int = getColor(R.color.red)) =
        this.watchFaceColors {
            main = LIGHT_MAIN
            highlight = accentColor
            background = LIGHT_BACKGROUND
        }

    companion object {
        const val LIGHT_MAIN = Color.BLACK
        const val LIGHT_BACKGROUND = Color.WHITE
        const val DARK_MAIN = Color.WHITE
        const val DARK_BACKGROUND = Color.BLACK
    }

}