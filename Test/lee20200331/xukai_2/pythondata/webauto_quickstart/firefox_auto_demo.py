from selenium import webdriver
# 导入webdriver包
import os
driver = webdriver.Firefox() # 初始化一个火狐浏览器实例：driver

driver.get("https://www.baidu.com")

dr = driver.find_element_by_id('kw')

dr.send_keys("web自动化")

dr = driver.find_element_by_id('su')

dr.click()

driver.quit() # 关闭并退出浏览器