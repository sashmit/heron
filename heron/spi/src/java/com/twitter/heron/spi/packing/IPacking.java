// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.twitter.heron.spi.packing;

import com.twitter.heron.spi.common.Config;

/**
 * Packing algorithm to use for packing multiple instances into containers. Packing hints like
 * number of container may be passed through scheduler config.
 */
public interface IPacking extends AutoCloseable {

  /**
   * Initialize the packing algorithm with the static and runtime config
   */
  void initialize(Config config, Config runtime);

  /**
   * Called by scheduler to generate container packing.
   * Packing algorithm output generates instance id and container id.
   *
   * @return PackingPlan describing the job to schedule.
   */
  PackingPlan pack();

  /**
   * This is to for disposing or cleaning up any internal state accumulated by
   * the uploader
   * <p>
   * Closes this stream and releases any system resources associated
   * with it. If the stream is already closed then invoking this
   * method has no effect.
   */
  void close();
}
