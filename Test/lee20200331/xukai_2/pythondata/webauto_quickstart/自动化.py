from selenium import webdriver

driver = webdriver.Chrome(r'f:\chromedriver.exe')

driver.get('http://www.51job.com')

example = driver.find_element_by_id('kwdselectid')

example.send_keys('java')

example = driver.find_element_by_id('work_position_input')

example.click()

examples = driver.find_elements_by_css_selector('#work_position_click_center_right_list_000000 em[class=on]')

for example in examples:
    example.click()

example = driver.find_element_by_id('work_position_click_ip_location_000000_090900')

example .click()

driver.find_element_by_id('work_position_click_center_right_list_category_000000_090200').click()

driver.find_element_by_id('work_position_click_bottom_save').click()

driver.find_element_by_css_selector('.ush button').click()