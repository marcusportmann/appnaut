/*
 * Copyright 2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appnaut.jta.test;

import java.util.List;

public interface IDataService {

  /**
   * Create a new data.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createData(Data data);

  /**
   * Create a new data with a nested transaction and throw a checked Exception with no rollback.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithNewTransactionAndNoRollbackOnException(
      Data data) throws Exception;

  /**
   * Create a new data with a nested transaction and throw a checked Exception.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithNewTransactionAndRollbackOnException(
      Data data) throws Exception;

  /**
   * Create a new data with a nested transaction and throw a RuntimeException.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithNewTransactionAndRollbackOnRuntimeException(
      Data data);

  /**
   * Create a new data and throw a checked Exception with no rollback.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithNoRollbackOnException(Data data) throws Exception;

  /**
   * Create a new data and throw a checked Exception.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithRollbackOnException(Data data) throws Exception;

  /**
   * Create a new data and throw a RuntimeException.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  Data createDataWithRollbackOnRuntimeException(Data data);

  /**
   * Retrieve the data.
   *
   * @return the data
   */
  List<Data> getAllData();
}
